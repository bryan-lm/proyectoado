import React from 'react';

const Input = ({value, onChange, id, name, type, placeholder, text}) => {
  return (
    <div className='my-5'>
        <label
            htmlFor={id}
            className='uppercase text-green-500 block text-xl font-bold'
        > 
            {text}
        </label>
        <input 
            value={value}
            onChange={onChange}
            name={name}
            id={id}
            className='w-full mt-3 p-3 border rounded-xl bg-gray-50 shadow-lg'
            type={type} 
            placeholder={placeholder} 
            required
        />
    </div>
  )
}


export default Input