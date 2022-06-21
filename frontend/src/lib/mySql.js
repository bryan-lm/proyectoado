import axios from 'axios'

const login = (user, pass) => {
    const res = axios.get('http://localhost:8080/api/login');
    return res;  
}