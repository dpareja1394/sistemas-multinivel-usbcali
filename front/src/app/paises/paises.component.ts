import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { PaisesService } from '../paises.service';
import { Pais } from '../models/pais';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatGridListModule } from '@angular/material/grid-list';


@Component({
  selector: 'app-paises',
  standalone: true,
  imports: [CommonModule,
            MatTableModule,
            MatCardModule,
            MatMenuModule,
            MatIconModule,
            MatButtonModule,
            ReactiveFormsModule,
            MatInputModule,
            MatGridListModule
          ],

  templateUrl: './paises.component.html',
  styleUrl: './paises.component.scss'
})
export class PaisesComponent implements OnInit {
  dataSource: MatTableDataSource<Object> = new MatTableDataSource<Object>([]);

  listColumnas: string[] = [
    'id',
    'codigo',
    'nombre',
    'descripcion',
    'opciones'
  ];

  form!: FormGroup;
 
  isForm!: Promise<any>;

  constructor(private paisesService:PaisesService,private formBuilder: FormBuilder){
    
  }
  ngOnInit(): void {
    this.iniciarFormulario();
    this.cargarDatos();
  }

  private iniciarFormulario(): void {
    this.isForm = Promise.resolve(
      (this.form = this.formBuilder.group({
        codigo: new FormControl(null, [Validators.required]),
        nombre: new FormControl(null,  [Validators.required]),
        descripcion: new FormControl(null, []),
      }))
    );
  }

 private cargarDatos(): void{
  this.paisesService.consultarPaises().subscribe((respuesta:Pais[])=>{
    this.dataSource=new MatTableDataSource<Object>(respuesta);
  });
 }

  guardarPais(): void{
    const values = this.form.value;
    let pais: Pais={
      codigo:values.codigo,
      nombre:values.nombre,
      descripcion:values.descripcion
    };
    
    this.paisesService.crearPais(pais).subscribe((respuesta:Pais)=>{
      this.cargarDatos();
    });
  }
  
}
