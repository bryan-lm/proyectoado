import axios from 'axios'

export const login = async(user, pass) => {
    const res = await axios.get('http://localhost:8080/api/Login', {params:{
        user:user,
        pass:pass,
    }});
    return res;  
}