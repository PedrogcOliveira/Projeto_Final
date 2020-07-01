<template>
  <div class="Lista">
    <div v-show="personagens.length == 0">
    <h1 class="title">Ah não!</h1>
    <p>Parece que nossa coleção está vazia... Mas não se preocupe, você pode mudar isso.</p>
    <a class="has-text-link" href="#registrePersonagem">Adicione um personagem clicando aqui.</a>
    </div>
    <h1 class="title" v-show="personagens.length > 0">Todos os personagens armazenados</h1>
    <table class="highlight centered" v-show="personagens.length > 0">
        <thead>
          <tr>
              <th>ID</th>
              <th>Nome</th>
              <th>Descrição</th>
              <th>Habilidade</th>
              <th>Ataque</th>
              <th>Defesa</th>
              <th>Excluir</th>
          </tr>
        </thead>

        <tbody>
          <tr v-for="personagem in personagens" :key="personagem.id">
            <td>{{personagem.id}}</td>
            <td>{{personagem.nome}}</td>
            <td>{{personagem.descricao}}</td>
            <td>{{personagem.habilidade}}</td>
            <td>{{personagem.forca}}</td>
            <td>{{personagem.defesa}}</td>
            <td><button class="button" type="button" @click="deletePersonagem(personagem)">Excluir</button></td>
          </tr>
        </tbody>
      </table>
  </div>
</template>

<script>

import PersonagemServices from '../services/personagemservices'
import swal from 'sweetalert';

export default {
  data() {
    return {
      personagem: {
        id: '',
        nome: '',
        descricao: '',
        habilidade: '',
        forca: '',
        defesa: ''
      },
      personagens: [],
      findPersonagem: {
        id: '',
        nome: '',
        descricao: '',
        habilidade: '',
        forca: '',
        defesa: ''
      }
    }
  },
  name: 'Lista',
  components: {

  },
  mounted() {
    this.listPersonagens();
  },
  methods: {
    listPersonagens() {
      PersonagemServices.findAll().then(response => {
        this.personagens = response.data;
      });
    },
    saveAndUpdatePersonagem() {
      if(!this.personagem.id) {
        PersonagemServices.save(this.personagem).then(response => {
          this.listPersonagens();
          this.personagem = {};
          alert("Personagem salvo.");
          return response;
        });
      } else {
        PersonagemServices.update(this.personagem).then(response => {
          this.listPersonagens();
          this.personagem = {};
          alert("Personagem alterado.");
          return response;
        });
      }
    },
    deletePersonagem(personagem) {
      swal({
        title: "Deletar o personagem?",
        text: "Uma vez deletado, ele será removido da coleção!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      }).then((willDelete) => {
        if (willDelete) {
          PersonagemServices.delete(personagem).then(response => {
              this.listPersonagens();
              return response;
            });
          swal("Adeus, personagem indesejável!", {
            icon: "success",
          });
        }
      });
    },
    findById() {
      PersonagemServices.findById(this.personagem).then(response => {
        this.findPersonagem = response.data;});
    },
    updatePersonagem(personagem) {
      this.personagem = personagem;
    },
    cancelUpdate() {
      this.personagem = {};
      //alert("Alteração cancelada.");
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.title {
  margin-top: 100px;
}

a {
  color: #f5f5f5;
}

table, th, td {
  border: none;
}

table {
  width: 100%;
  display: table;
  border-collapse: collapse;
  border-spacing: 0;
}

table.striped tr {
  border-bottom: none;
}

table.striped > tbody > tr:nth-child(odd) {
  background-color: rgba(242, 242, 242, 0.5);
}

table.striped > tbody > tr > td {
  border-radius: 0;
}

table.highlight > tbody > tr {
  -webkit-transition: background-color .25s ease;
  transition: background-color .25s ease;
}

table.highlight > tbody > tr:hover {
  background-color: rgba(242, 242, 242, 0.5);
}

table.centered thead tr th, table.centered tbody tr td {
  text-align: center;
}

tr {
  border-bottom: 1px solid rgba(0, 0, 0, 0.12);
}

td, th {
  padding: 15px 5px;
  display: table-cell;
  text-align: left;
  vertical-align: middle;
  border-radius: 2px;
}

@media only screen and (max-width: 992px) {
  table.responsive-table {
    width: 100%;
    border-collapse: collapse;
    border-spacing: 0;
    display: block;
    position: relative;
    /* sort out borders */
  }
  table.responsive-table td:empty:before {
    content: '\00a0';
  }
  table.responsive-table th,
  table.responsive-table td {
    margin: 0;
    vertical-align: top;
  }
  table.responsive-table th {
    text-align: left;
  }
  table.responsive-table thead {
    display: block;
    float: left;
  }
  table.responsive-table thead tr {
    display: block;
    padding: 0 10px 0 0;
  }
  table.responsive-table thead tr th::before {
    content: "\00a0";
  }
  table.responsive-table tbody {
    display: block;
    width: auto;
    position: relative;
    overflow-x: auto;
    white-space: nowrap;
  }
  table.responsive-table tbody tr {
    display: inline-block;
    vertical-align: top;
  }
  table.responsive-table th {
    display: block;
    text-align: right;
  }
  table.responsive-table td {
    display: block;
    min-height: 1.25em;
    text-align: left;
  }
  table.responsive-table tr {
    border-bottom: none;
    padding: 0 10px;
  }
  table.responsive-table thead {
    border: 0;
    border-right: 1px solid rgba(0, 0, 0, 0.12);
  }


}
</style>
