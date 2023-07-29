import React from 'react'
import { useNavigate } from 'react-router-dom'
import { baseUrl } from './Api';
import axios from 'axios';
import TableRow from './TableRow';
export default function Table() {  
  const navigate = useNavigate();
  const { data } = axios.get(`${baseUrl}/getusers`);
  return (
    <div>
      <table className="table">
      <thead className="thead-dark">
        <tr>
          <th scope="col">#</th>
          <th scope="col">user Details</th>
          <th scope="col">Amount</th>
          <th scope="col">Year</th>
          <th scope="col">JAN</th>
          <th scope="col">FEB</th>
          <th scope="col">MAR</th>
          <th scope="col">APR</th>
          <th scope="col">MAY</th>
          <th scope="col">JUN</th>
          <th scope="col">JUL</th>
          <th scope="col">AUG</th>
          <th scope="col">SEP</th>
          <th scope="col">OCT</th>
          <th scope="col">NOV</th>
          <th scope="col">DEC</th>
        </tr>
      </thead>
      <tbody>
        {data.map((user) => {
          return <TableRow user={user} />
        })}
      </tbody>  
    </table>
    <div className='row'>
        <div className='col align-center'>
          <button type="button" className="btn btn-primary" onClick={()=>{navigate('/AddUser')}}>Register user</button>
        </div>
        <div className='col'>
        <button type="button" className="btn btn-primary" onClick={()=>{navigate('/addEntry')}}>Add Payment</button>
        </div>
      </div>
  </div>
  )
}
