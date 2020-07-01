import { http } from './api'

export default {

  findAll: () => {
    return http.get('personagens');
  },

  findById: (personagem) => {
    return http.get(`personagens/${personagem.id}`, { data: personagem });
  },

  save: (personagem) => {
    return http.post('personagens', personagem);
  },

  delete: (personagem) => {
    return http.delete(`personagens/${personagem.id}`, { data: personagem });
  },

  update: (personagem) => {
    return http.put(`personagens`, personagem);
  }

}
