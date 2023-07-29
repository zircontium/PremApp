import React from 'react'
import axios from 'axios';
import { baseUrl } from './Api';
import TableRow1 from './TableRow1';
import TableRow2 from './TableRow2';
import TableRow3 from './TableRow3';
import TableRow4 from './TableRow4';
import TableRow5 from './TableRow5';

export default function TableRow({users}) {

    const getLastDonation = async () => {
        const { data } = await axios.get(`${baseUrl}/getLastDonation`);
        console.log(data);
    };
    return (
        <div>
            <TableRow1></TableRow1>
            <TableRow2></TableRow2>
            <TableRow3></TableRow3>
            <TableRow4></TableRow4>
            <TableRow5></TableRow5>
        </div>
    )
}
