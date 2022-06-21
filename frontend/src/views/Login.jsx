import React, {useState} from 'react'
import {Input} from '../components'
import { useNavigate } from 'react-router-dom';

const Login = () => {

  const [ LoginData, setLoginData ] = useState({
    user:'',
    password:''
  });
  const navigate = useNavigate();
  const {user, password} = LoginData;

  const handleInputChange = (e) => setLoginData({...LoginData, [e.target.name]:e.target.value});

  const handleSubmit = async(e) =>{
    
    e.preventDefault();
      if(user==='admin' && password==='123') navigate('/dashboard');
      else navigate('login-error')
  }

  return (
    <>
      <h1 className='text-green-600 text-3xl md:text-5xl capitalize font-black'>Calculadora de intersecciones</h1>
      
      
      <form
        onSubmit={handleSubmit}
        className=' my-10 bg-white shadow rounded-lg p-10'>
          <Input
            id="user" name="user" type="user" text="Usuario" placeholder="Cejota"
            onChange={handleInputChange} value={user}      
          />
          <Input
            id="passwordLogin" name="password" type="password" text="Password"
            onChange={handleInputChange} value={password}
          />
          
        <button className='bg-green-500 w-full py-3 text-white uppercase font-bold rounded-lg cursor-pointer transition-all ease-in-out 300 hover:bg-green-700'>
          Log in
        </button>
      </form>
      <nav className='lg:flex lg:justify-between'>
      </nav>
    </>
  )
}

export default Login