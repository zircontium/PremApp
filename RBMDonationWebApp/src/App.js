import logo from './logo.svg';
import './App.css';
import Table from './Table';
import Header from './Header';
import AddUser from './AddUser';
import AddEntry from './AddEntry';
import UserDetails from './UserDetails';
import { BrowserRouter as Router,Routes, Route} from 'react-router-dom'

function App() {
  return (
    <div>
      <Router>
        <Header/>
        <Routes>
          <Route path='/' element={<Table/>}/>
          <Route path='/addEntry' element={<AddEntry/>}/>
          <Route path='/AddUser' element={<AddUser/>}/>
          <Route path='/view' element={<UserDetails/>}/>
        </Routes>
      </Router> 
    </div>
  );
}

export default App;
