import { CommonModule } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Pensamento } from '../pensamento';


@Component({
  selector: 'app-pensamento',
  imports: [CommonModule, RouterModule],
  templateUrl: './pensamento.component.html',
  styleUrl: './pensamento.component.css'
})



export class PensamentoComponent implements OnInit{

    @Input() pensamento : Pensamento = {
        conteudo: 'I love Angular',
        autoria: 'Rafael Paz',
        modelo: 'modelo3'
    }

  constructor() { }

  ngOnInit(): void {

  }

  

  larguraPensamento() : string {
    if (this.pensamento.conteudo.length >= 256) {
      return 'pensamento-g'
    }
    return 'pensamento-p';
  }

}
