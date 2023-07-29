import React, { useState } from 'react'
import { useNavigate } from "react-router-dom"
import { baseUrl } from './Api';
import axios from 'axios';
export default function AddEntry() {
    const navigate = useNavigate();
    const [inputs, setInputs] = useState({});
    const { data } = axios.get(`${baseUrl}/getuser`);
    console.log(data)
    const handleChange = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        setInputs(values => ({ ...values, [name]: value }))
    }
    const onFileChange = (event) => {
        const name = event.target.name;
        const value = event.target.files[0];
        let imageURL = URL.createObjectURL(value);
        setInputs(values => ({ ...values, [name]: imageURL }))
        console.log(imageURL);
        //var image = document.getElementById('output');
        imageURL = URL.createObjectURL(value);
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        navigate("/")
        //   addCard(inputs);
    };
    const httpAddDonation = async () => {
        const { data } = await axios.put(`${baseUrl}/addDonation`);
        console.log(data)
    };
  return (<div>

    <h3>Smt. Aditi Dutta</h3>
    <form onSubmit={handleSubmit}>
        <div className="form-group container p-3">
            <div className="container p-3">
                <h3>Add Payment</h3>
                <label>Date:</label>
                <input type="date" name="DATE" onChange={handleChange} value={inputs.DATE || ""} className="form-control" id="exampleInputEmail1" required/>
                <label>Reciept No.:</label>
                <input type="number" name="RECIEPT_NO" onChange={handleChange} value={inputs.RECIEPT_NO || ""} className="form-control" id="exampleInputEmail1" required/>
                <label>Payment Amount:</label>
                <input type="number" name="AMOUNT" onChange={handleChange} value={inputs.AMOUNT || ""} className="form-control" id="exampleInputEmail1" required/>
                <label>Start Month:</label>
                <input list="months" name="START_MONTH" onChange={handleChange} value={inputs.START_MONTH || ""} className="form-control" id="exampleInputEmail1" />
                <label>Start Year:</label>
                <input type="number" name="START_YEAR" onChange={handleChange} value={inputs.START_YEAR || ""} className="form-control" id="exampleInputEmail1" required/>
                <label>End Month:</label>
                <input list="months" name="END_MONTH" onChange={handleChange} value={inputs.END_MONTH || ""} className="form-control" id="exampleInputEmail1" required/>
                <label>End Year:</label>
                <input type="number" name="END_YEAR" onChange={handleChange} value={inputs.END_YEAR || ""} className="form-control" id="exampleInputEmail1" required/>
                <datalist id="months">
                    <option value="January"></option>
                    <option value="February"></option>
                    <option value="March"></option>
                    <option value="April"></option>
                    <option value="May"></option>
                    <option value="June"></option>
                    <option value="July"></option>
                    <option value="August"></option>
                    <option value="September"></option>
                    <option value="October"></option>
                    <option value="November"></option>
                    <option value="December"></option>
                </datalist> 
            </div>
            <div className="container p-3">
                <h3>Total Amount:</h3>
                <h2>50</h2>
            </div>
            <div className="container p-3 ">
                <button type="submit" className="btn btn-primary mx-3" onClick={httpAddDonation}>Submit</button>
                <button type="Discard" className="btn btn-danger mx-3" onClick={() => navigate("/")}>Cancel</button>
            </div>

        </div>
    </form>
</div>
  )
}
