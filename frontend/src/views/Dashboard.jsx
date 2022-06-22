import React from 'react'

const Dashboard = () => {
  return (
    <section className='mt-20 w-full p-10 relative'>
      <div className='w-full'>
        <button className='bg-green-500 p-2 rounded-lg   text-white'>Crear Nuevo ejercicio</button>
        



        <div className="flex flex-col bg-white mt-10">
          <div className="overflow-x-auto sm:-mx-6 lg:-mx-8">
            <div className="py-2 inline-block min-w-full sm:px-6 lg:px-8">
              <div className="overflow-hidden">
                <table className="min-w-full border text-center">
                  <thead className="border-b">
                    <tr>
                      <th scope="col" className="text-sm font-medium text-gray-900 px-6 py-4 border-r">
                        Usuario
                      </th>
                      <th scope="col" className="text-sm font-medium text-gray-900 px-6 py-4 border-r">
                        Acciones
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr className="border-b">
                      
                      <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap border-r">
                        Ejercicio
                      </td>
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
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>




      </div>
    </section>
  )
}

export default Dashboard