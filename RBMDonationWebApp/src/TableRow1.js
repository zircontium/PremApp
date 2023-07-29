import React from 'react'
import { useNavigate } from 'react-router-dom';
export default function TableRow1(user) {
    const navigate = useNavigate();
  return (
    <tr>
          <th scope="row">4</th>
          <td>{user?.salutation + user.firstName + user?.middleName + user?.lastName} <button type="button" className="btn btn-primary" onClick={()=>{navigate('/addEntry')}}>Add Payment</button></td>
          <td>20/-</td>
          <td>2019</td>
          <td>Paid</td>
          <td>Paid</td>
          <td>Paid</td>
          <td>Paid</td>
          <td>Paid</td>
          <td>Paid</td>
          <td>Paid</td>
          <td>Paid</td>
          <td>Paid</td>
          <td>Paid</td>
          <td>Paid</td>
          <td>Paid</td>
        </tr>
  )
}
