import React, { useState } from 'react'
import { useNavigate } from "react-router-dom"
import axios from "axios";
import { AddUserApi } from './Api';
const baseUrl = "http://localhost:8080";

export default function AddUser() {
    const navigate = useNavigate();
    const [inputs, setInputs] = useState({});

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
    }

    // const httpAddUser = () => {
    //     await fetch('https://localhost:8080/AddUser', {method: "PUT"}
    //     // body: JSON.stringify({
    //     //   userId: 55,
    //     //   id: 101,
    //     //   title: "New Post title",
    //     //   body: "New Post body",
    //     )
    //     .then(response => response.json())
    //     .then(data => console.log(data));
    // }

    const httpAddUser = async () => {
        const { data } = await axios.put(`${baseUrl}/AddUser`);
        console.log(data)

    //     AddUser.then((res) => {
    //         console.log(res)
    //       })
    //       .catch((err) => console.log(err.message));
    };

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div className="form-group container p-3">
                    <label><h4>user Details:</h4></label>
                    <div className="container p-3">
                        <h3>Personal</h3>
                        <label>Id No.:</label>
                        <input type="number" name="ID" onChange={handleChange} value={inputs.ID || ""} className="form-control" id="exampleInputEmail1" required/>
                        <label>Salutation:</label>
                        <input list="salutation" name="SALUTATION" onChange={handleChange} value={inputs.SALUTATION || ""} className="form-control" id="exampleInputEmail1" />
                        <datalist id="salutation">
                            <option value="Shree"></option>
                            <option value="Shreemati"></option>
                            <option value="Dr."></option>
                        </datalist>
                        <label>First Name:</label>
                        <input type="text" name="FIRST_NAME" onChange={handleChange} value={inputs.FIRST_NAME || ""} className="form-control" id="exampleInputEmail1" required/>
                        <label>Mid Name:</label>
                        <input type="text" name="MID_NAME" onChange={handleChange} value={inputs.MID_NAME || ""} className="form-control" id="exampleInputEmail1" />
                        <label>Last Name:</label>
                        <input type="text" name="LAST_NAME" onChange={handleChange} value={inputs.LAST_NAME || ""} className="form-control" id="exampleInputEmail1" required/>
                    </div>

                    <div className="container p-3">
                        <h3>Address</h3>
                        <label>Line 1:</label>
                        <input type="text" name="ADDRESS_1" onChange={handleChange} value={inputs.ADDRESS_1 || ""} className="form-control" id="exampleInputEmail1" required/>
                        <label>Line 2:</label>
                        <input type="text" name="ADDRESS_2" onChange={handleChange} value={inputs.ADDRESS_2 || ""} className="form-control" id="exampleInputEmail1" />
                        <label>City:</label>
                        <input type="text" name="CITY" onChange={handleChange} value={inputs.CITY || ""} className="form-control" id="exampleInputEmail1" required/>
                        <label>PIN code:</label>
                        <input type="number" name="POSTAL_CODE" onChange={handleChange} value={inputs.POSTAL_CODE || ""} className="form-control" id="exampleInputEmail1" maxlength="7" max="9999999"/>
                        <label>State:</label>
                        <input list="STATE" name="STATE" onChange={handleChange} value={inputs.STATE || ""} className="form-control" id="stateOptions" required/>
                        <datalist id="STATE">
                            <option value="Chrome"></option>
                            <option value="Firefox"></option>
                            <option value="Opera"></option>
                            <option value="Safari"></option>
                            <option value="Microsoft Edge"></option>
                        </datalist>
                    </div>
                    <div className="container p-3">
                        <h3>Contact Details</h3>
                        <label>Phone No.:</label>
                        <input type="number" name="PHONE" onChange={handleChange} value={inputs.PHONE || ""} className="form-control" id="exampleInputEmail1" maxlength="10" min="1000000000" max="9999999999" required/>
                        <label>Email:</label>
                        <input type="email" name="EMAIL" onChange={handleChange} value={inputs.EMAIL || ""} className="form-control" id="exampleInputEmail1"/>
                        <label>ID Proof:</label>
                        <input type="text" name="ID_PROOF" onChange={handleChange} value={inputs.ID_PROOF || ""} className="form-control" id="exampleInputEmail1"/>
                        
                    </div>

                    <div className="container p-3 ">
                        <button type="submit" className="btn btn-primary mx-3"  onClick={httpAddUser}>Submit</button>
                        <button type="Discard" className="btn btn-danger mx-3" onClick={() => navigate("/")}>Cancel</button>
                    </div>

                </div>
            </form>
        </div>
    )
}
