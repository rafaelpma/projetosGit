import { Component, Input, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Router, ActivatedRoute } from '@angular/router';
import { PensamentoService } from '../pensamento.service';
import { Pensamento } from '../pensamento';





@Component({
  selector: 'app-editar-pensamento',
  imports: [FormsModule, RouterModule],
  templateUrl: './editar-pensamento.component.html',
  styleUrl: './editar-pensamento.component.css'
})
export class EditarPensamentoComponent implements OnInit{
  constructor(
    private service: PensamentoService,
    private router: Router,
    private route: ActivatedRoute
  ){ }

  
  pensamento: Pensamento = {
    id: 0,
    conteudo: '',
    autoria: '',
    modelo: 'modelo1'
  }

  editarPensamento(){


    this.service.editar(this.pensamento).subscribe(() => {
      this.router.navigate(['/listarPensamento']);
    })
  }

  cancelar(){
    this.router.navigate(['/listarPensamento']);
  }

  ngOnInit(): void {

    const id = this.route.snapshot.paramMap.get('id')
    alert("id : "+id)
    this.service.buscarPorId(parseInt(id!)).subscribe((pensamento) => {
      alert("autor :"+pensamento.autoria)
      this.pensamento = pensamento
    })

  }

}
