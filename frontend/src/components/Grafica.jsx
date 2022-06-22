import React, { useEffect } from 'react'
import functionPlot from 'function-plot'


const Grafica = ({data}) => {
  
    const chartRef = useRef(null);
    let contentsBounds = document.body.getBoundingClientRect();
  let width = 800;
  let height = 500;
  let ratio = contentsBounds.width / width;
  width *= ratio;
  height *= ratio;

  useEffect(() => {
    const mostrarGrafica = (data)=>{
        functionPlot({
            target: "#grafica",
            width,
            height,
            yAxis: { domain: [-10, 10] },
            xAxis: { domain: [-10, 10] },
            grid: true,
            data: [
              {
                fn: `${data.funcion}`,
              }
            ]
          });
    }
  }, [])
  


    return (
    <div id='grafica' ref={chartRef}>

    </div>
  )
}

export default Grafica