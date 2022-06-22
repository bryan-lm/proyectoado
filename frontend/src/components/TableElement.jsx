import React from 'react'

const TableElement = () => {
  return (
    <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap border-r flex items-center justify-center gap-10">

                        <div>
                          <button className='btn-action'>Ver ejercicio</button>
                        </div>
                        <div>w
                          <button className='btn-action'>Modificar ejercicio</button>
                        </div>
                        <div>
                          <button className='btn-action'>Eliminar Ejercicio</button>
                        </div>
                        <div>
                          <button className='btn-action'>Probar Ejercicio</button>
                        </div>

    </td>
  )
}

export default TableElement