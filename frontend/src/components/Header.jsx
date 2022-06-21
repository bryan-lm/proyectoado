import React from 'react'


const Header = () => {
  
    
    return (
    <header className=" bg-black px-4 py-5 bg-black-base border-b shadow-lg fixed w-screen">
        <div className="md:flex md:justify-between md:items-center">
            <h2 className='text-2xl md:text-3xl text-green-500'>Welcome Admin <span className='text-white'>Crear altas, bajas y cambios de ejercicios</span></h2>
            <button  className='bg-green-500 p-2 text-white w-20 rounded-md'>Salir</button>
        </div>
    </header>
  )
}

export default Header