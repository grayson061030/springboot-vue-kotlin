
import axios from 'axios'  
  
const SERVER_URL = 'http://localhost:8090'
  
const instance = axios.create({  
  baseURL: SERVER_URL,  
  timeout: 1000  
})

export default {
    getMembers:() => instance.get('/members', {
        transformResponse: [function (data) {
            return data? JSON.parse(data) : data;
        }]
    })
}