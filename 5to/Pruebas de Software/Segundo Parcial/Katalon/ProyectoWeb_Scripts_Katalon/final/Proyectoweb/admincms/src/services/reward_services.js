import axios from 'axios';
import { BASE_PATH_DB } from '../utils/config';

async function createReward(data) {
    await axios.post(`${BASE_PATH_DB}/reward`,data)
      .then(response => {
        console.log('Error del servidor',response.data);
      })
  }

  async function updateReward(data,id) {
    console.log(data);
    await axios.put(`${BASE_PATH_DB}/reward/${id}`,data)
      .then(response => {
        console.log('Error del servidor',response.data);
      })
  }

  async function deleteReward(id) {
    await axios.delete(`${BASE_PATH_DB}/reward/${id}`)
      .then(response => {
        console.log('Error del servidor',response.data);
      })
  }

export {createReward, updateReward, deleteReward};