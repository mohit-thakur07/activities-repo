import { Route, Routes } from 'react-router-dom';
import './App.css';
import { CustomerLogin, CustomerRegistration, CustomerSuccess } from './components/customer/Customer';
import { AdminLogin, AdminSuccess } from './components/admin/Admin';

function App() {
  return (
    <div>
      <div className='alert alert-secondary'>
          <h2 className='text-center'>Loan Application</h2>
        </div>
      <div className='container-fluid'>
        <Routes>
          <Route path="" element={<CustomerLogin />}></Route>
          <Route path="/login" element={<CustomerLogin />}></Route>
          <Route path="/register" element={<CustomerRegistration />}></Route>
          <Route path="/success/:emailId/*" element={<CustomerSuccess />}></Route>
          <Route path="/admin" element={<AdminLogin />}></Route>
          <Route path="/admin/login" element={<AdminLogin />}></Route>
          <Route path="/admin/success/:emailId/*" element={<AdminSuccess />}></Route>
        </Routes>
      </div>
    </div>
  );
}

export default App;
