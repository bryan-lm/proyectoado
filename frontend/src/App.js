import { Routes, Route } from 'react-router-dom';
import {AuthLayout, DashboardLayout} from './Layout';
import {Login, ErrorLogin, Dashboard} from './views'

function App() {
  return (
    <Routes>
      
      <Route path='/' element={ <AuthLayout/> }>
        <Route index element={ <Login/> }/>
        <Route path='login-error' element={ <ErrorLogin/> } />
      </Route>

      <Route path='/dashboard' element={<DashboardLayout/>}>
        <Route index element={<Dashboard/>}/>
      </Route>

      




    </Routes>
  );
}

export default App;
