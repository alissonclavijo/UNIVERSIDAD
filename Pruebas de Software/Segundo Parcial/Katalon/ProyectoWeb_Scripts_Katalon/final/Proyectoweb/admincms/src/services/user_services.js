import axios from 'axios';
import { BASE_PATH_DB } from '../utils/config';

async function createUser(data) {
    await axios.post(`${BASE_PATH_DB}/user`,data)
      .then(response => {
        console.log('Error del servidor',response.data);
      })
  }

  async function updateUser(data,id) {
    await axios.put(`${BASE_PATH_DB}/user/${id}`,data)
      .then(response => {
        console.log('Error del servidor',response.data);
      })
  }

  async function deleteUser(id) {
    await axios.delete(`${BASE_PATH_DB}/user/${id}`)
      .then(response => {
        console.log('Error del servidor',response.data);
      })
  }

export {createUser, updateUser, deleteUser};