<template>
  <div id="app">

    <!-- NAVBAR -->
    <nav class="navbar is-transparent is-fixed-top is-black">
      <div class="navbar-brand">
        <a class="navbar-item" href="/">
          <img id="in_logo" src="./assets/injustice.png" alt="Injustice API: Personagens" >
        </a>
        <div class="navbar-burger burger" data-target="navbarExampleTransparentExample">
          <span></span>
          <span></span>
          <span></span>
        </div>
      </div>

      <div id="navbarExampleTransparentExample" class="navbar-menu">
        <div class="navbar-start">
        </div>

        <div class="navbar-end">
          <div id="in_menu_end" class="navbar-item">
            <div class="buttons">
              <a class="button is-white" href="/">Início</a>
              <a class="button is-white" href="/lista"><strong>Ver todos!</strong></a>
              <a class="button is-white" href="/sobre">Sobre nós</a>
            </div>
          </div>
        </div>
      </div>
    </nav>
    <!-- NAVBAR -->

    <!-- CORPO -->
    <section id="first_section" class="hero is-black is-bold is-fullheight">
      <div class="hero-body">
        <div class="container">

          <router-view></router-view>

          <div class="astrodivider">
            <div class="astrodividermask">
            </div>
            <span><i>★</i></span>
          </div>

            <!-- procurar por id -->
          <form @submit.prevent="findById" id="search">
            <div class="field">
              <label class="label">Procure um personagem por número de identificação (ID): </label>
              <div class="control">
                <input class="input" v-model="personagem.id" type="number" min="1" placeholder="ID do personagem..." required>
              </div>
            </div>
            <button class="button is-small is-fullwidth is-black is-bold">Procurar!</button>
          </form>

          <div class="search_result" v-show="findPersonagem.id">
            <p id="search_result_message">O personagem está armazenado na coleção.</p>
            <h3 id="search_result_title"><b>{{findPersonagem.nome}}!</b></h3>
            <p id="answer_search">{{findPersonagem.descricao}}<br><br>
            Sua habilidade principal é <b>{{findPersonagem.habilidade}}</b><br><br>
            Poder de ataque: <b>{{findPersonagem.forca}}</b><br><br>
            Poder de defesa: <b>{{findPersonagem.defesa}}</b>
          </p>
          </div>

          <!-- procurar por id -->

          <div v-show="!findPersonagem.id" i="divider_after_search">
            <p id="divider_after_search_text" class="has-text-weight-light is-size-5 has-text-right subtitle">Colabore com o crescimento da nossa coleção, tornando-a cada vez mais completa e interessante.<br>
            Possuímos atualmente {{personagens.length}} personagens registrados em nosso sistema!</p>
          </div>
          <div class="astrodivider">
            <div class="astrodividermask">
            </div>
            <span><i>★</i></span>
          </div>

          <!-- Cadastrar personagem -->
          <h1 id="registrePersonagem" style="margin-top: 100px" class="title">Registre um personagem!</h1>
          <form @submit.prevent="saveAndUpdatePersonagem" id="search">
            <div class="field">
              <div class="control">
                <input class="input" v-model="personagem.nome" type="text" min="1" max="255" placeholder="Nome do personagem" required>
                <input class="input" v-model="personagem.descricao" type="text" min="1" max="255" placeholder="Como você descreve esse personagem?" required>
                <input class="input" v-model="personagem.habilidade" type="text" min="1" max="255" placeholder="Qual sua principal habilidade?" required>
                <input class="input" v-model="personagem.forca" type="number" placeholder="Força de ataque" min="1" max="100" required>
                <input class="input" v-model="personagem.defesa" type="number" placeholder="Força de defesa" min="1" max="100" required>
              </div>
            </div>
            <button class="button is-small is-fullwidth is-black is-bold">Cadastrar!</button>
          </form>
          <!-- Cadastrar personagem -->
        </div>
      </div>
    </section>
    <!-- CORPO -->

    <!-- <section class="hero is-medium is-light is-bold">
      <div class="hero-body">
        <div class="container">
          <div v-show="findPersonagem.id">
            <p>O personagem está armazenado na coleção.</p>
            <h3><strong>{{findPersonagem.nome}}!</strong></h3>
          </div>

        <h2>Personagens armazenados</h2>
        <table class="table" v-show="personagens.length > 0">
          <thead>
            <tr>
              <th>ID</th>
              <th>Nome</th>
              <th>Descrição</th>
              <th>Habilidade</th>
              <th>Ataque</th>
              <th>Defesa</th>
              <th>Excluir</th>
              <th>Alterar</th>
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
              <td>
                <button class="button" type="button" @click="deletePersonagem(personagem)">Excluir</button>
              </td>
              <td>
                <button class="button" type="button" @click="updatePersonagem(personagem)">Alterar</button>
              </td>
            </tr>
          </tbody>
          <tfoot>
            <tr>
              <th>ID</th>
              <th>Nome</th>
              <th>Descrição</th>
              <th>Habilidade</th>
              <th>Ataque</th>
              <th>Defesa</th>
              <th>Excluir</th>
              <th>Alterar</th>
            </tr>
          </tfoot>
        </table>

        <h2>Armazenar personagem</h2>
        <form @submit.prevent="saveAndUpdatePersonagem">
          <div><input type="text" v-model="personagem.nome" placeholder="Qual o nome do personagem?"></div>
          <div><input type="text" v-model="personagem.descricao" placeholder="O que descreve esse personagem?"></div>
          <div><input type="text" v-model="personagem.habilidade" placeholder="Qual é seu grande trunfo?"></div>
          <div><input type="number" v-model="personagem.forca" placeholder="Sua força de ataque?"></div>
          <div><input type="number" v-model="personagem.defesa" placeholder="Sua força de defesa?"></div>
          <button class="button">Salvar</button>
          <button class="button" v-show="personagem.id" @click="cancelUpdate()">Cancelar</button>
        </form>
    </div>
      </div>
    </section> -->
  </div>
</template>

<script>
import PersonagemServices from './services/personagemservices'
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
  name: 'App',
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
          swal("Sucesso!", "Seu personagem foi acrescentado à coleção.", "success");
          return response;
        });
      } else {
        PersonagemServices.update(this.personagem).then(response => {
          this.listPersonagens();
          this.personagem = {};
          swal("Sucesso!", "Seu personagem foi alterado.", "success");
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
      PersonagemServices.update(this.personagem).then(response => {
        this.listPersonagens();
        this.personagem = {};
        alert("Personagem alterado.");
        return response;
      });
    }
  }
}
</script>

<style>
#app {
  /* font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50; */
  margin: 0px;
}

#in_logo {
  margin: 70px;
}

#in_menu_end {
  margin-right: 70px;
}

#first_section {
  /* background-image: url("./assets/batman.jpg"); */
}

#second_section {
  margin-top: 10px;
  text-align: center;
}

#search {
  margin-top: 50px;
}

#search_result_message {
  font-size: 25px;
}

#search_result_title {
  margin-top: 50px;
  font-size: 100px;
  color: white;
}

#answer_search {
  margin-top: 35px;
}

#divider_after_search {
  display: fixed;
}

#divider_after_search_text {
  margin-top: 100px;
  float: right;
}

.search_result {
  margin-top: 100px;
  margin-bottom: 200px;
  text-align: center;
}

.astrodivider {
  margin-top: 300px;
  width:1300px;
  max-width: 100%;
  position:relative;
}

.astrodividermask {
    overflow:hidden; height:20px;
}

.astrodividermask:after {
      content:'';
      display:block; margin:-25px auto 0;
      width:100%; height:25px;
      border-radius:125px / 12px;
      box-shadow:0 0 8px #fff;
}
.astrodivider span {
    width:50px; height:50px;
    position:absolute;
    bottom:100%; margin-bottom:-25px;
    left:50%; margin-left:-25px;
    border-radius:100%;
   box-shadow:0 2px 4px #fff;
    /* preenchimento do circulo */
    background:#000;
}
.astrodivider i {
    position:absolute;
    top:4px; bottom:4px;
    left:4px; right:4px;
    border-radius:100%;
    /* borda da coisa de dentro */
    border:1px dashed ##f5f5f5;
    text-align:center;
    line-height:40px;
    font-style:normal;
     color:#fff;
     /* coisa de dentro */
}
</style>
