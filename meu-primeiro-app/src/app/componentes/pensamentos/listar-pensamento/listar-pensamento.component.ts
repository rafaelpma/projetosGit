import { Component, OnInit } from '@angular/core';
import { RouterModule, Router, NavigationEnd } from '@angular/router';
import { PensamentoComponent } from "../pensamento/pensamento.component";
import { CommonModule } from '@angular/common';
import { Pensamento } from '../pensamento';
import { PensamentoService } from '../pensamento.service';

@Component({
  selector: 'app-listar-pensamento',
  imports: [CommonModule, RouterModule, PensamentoComponent],
  templateUrl: './listar-pensamento.component.html',
  styleUrl: './listar-pensamento.component.css'
})
export class ListarPensamentoComponent implements OnInit {
  listaPensamentos: Pensamento[] = [];

  constructor( 
    private services: PensamentoService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.carregarPensamentos();
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd){
        this.carregarPensamentos();
      }
    })
  }

  carregarPensamentos(){
      this.services.listar().subscribe((listaPensamentos) => {
      this.listaPensamentos = listaPensamentos
    })
  }


}
