import React from 'react'
import { Link } from 'react-router-dom'

const ErrorLogin = () => {
  return (
    <div className='bg-white p-5 rounded-xl flex items-center flex-col justify-center'>
        <h2 className='text-2xl  font-semibold'>Usuario no registrado en la aplicacion web</h2>
        <Link to={'/'} className='text-green-500 text-2xl'>Regresar al login para volver a intentar</Link>
    </div>
  )
}

export default ErrorLogin