import { useState } from "react";
import { Link, Route, Routes, useNavigate, useParams } from "react-router-dom";

export function CustomerSuccess() {
    let {emailId} = useParams();
    let dummyProfile = {
        name: "mohit", dob: "2001-12-07", phone: "8818843311",
        url: "https://wallpapercave.com/wp/wp8412692.jpg"
    }

    return (<div className="row">
        <div className="col-4">
            <img src={dummyProfile.url} width={200} height={300} />
            <p>Name: {dummyProfile.name}</p>
            <p>Birth date: {dummyProfile.dob}</p>
            <p>Number: {dummyProfile.number}</p>
        </div>
        <div className="col-6">
            <Link to="dashboard">Dashboard</Link><br />
            <Link to="addContacts">Add Contacts</Link><br />
            <Link to="viewContacts">View Contacts</Link><br />
            <Link to="wallet">Wallet</Link><br />
            <div>
                <Routes>
                    <Route path="" element={<div>Welcome, {dummyProfile.name}</div>}></Route>
                    <Route path="dashboard" element={<div>Welcome, {dummyProfile.name}</div>}></Route>
                    <Route path="addContacts" element={<div>Add contacts</div>}></Route>
                    <Route path="viewContacts" element={<div>View Contacts</div>}></Route>
                    <Route path="wallet" element={<div>Wallet balance: 500</div>}></Route>
                </Routes>
            </div>
        </div>
    </div>)
}

export function CustomerRegistration() {
    let [emailId, setEmailId] = useState('');
    let [password, setPassword] = useState('');
    let [fname, setFName] = useState('');
    let [lname, setLName] = useState('');
    let [phone, setPhone] = useState('');
    let [pan, setPan] = useState('');

    const navigate = useNavigate();

    let handleSubmit = (e) => {
        e.preventDefault();
        navigate("/login");
    }

    return (<div>
        <h3>Registration Form</h3><hr />
        <form onSubmit={handleSubmit}>
            <div>
                <p className="text-danger">* mandatory fields</p>
            </div>
            <div className="w-25">
                <label>Enter first name</label><label className="text-danger">*</label>
                <input type="text" className="form-control" onChange={e => setFName(e.target.value)}></input>
            </div><br />
            <div className="w-25">
                <label>Enter last name</label><label className="text-danger">*</label>
                <input type="text" className="form-control" onChange={e => setLName(e.target.value)}></input>
            </div><br />
            <div className="w-25">
                <label>Enter Email Id</label><label className="text-danger">*</label>
                <input type="email" className="form-control" onChange={e => setEmailId(e.target.value)}></input>
            </div><br />
            <div className="w-25">
                <label>Enter password</label><label className="text-danger">*</label>
                <input type="password" className="form-control" onChange={e => setPassword(e.target.value)}></input>
            </div><br />
            <div className="w-25">
                <label>Enter phone</label><label className="text-danger">*</label>
                <input type="text" className="form-control" onChange={e => setPhone(e.target.value)}></input>
            </div><br />
            <div className="w-25">
                <label>Enter pan</label><label className="text-danger">*</label>
                <input type="text" className="form-control" onChange={e => setPan(e.target.value)}></input>
            </div><br />
            <div>
                <input type="submit" className="btn btn-primary" value='Register'></input>
            </div>
        </form><br />
        <div>
            <Link to="/login">Already registered? Login</Link>
        </div>
    </div>);
}

export function CustomerLogin() {
    let [emailId, setEmailId] = useState("");
    let [password, setPassword] = useState("");

    const navigate = useNavigate();

    let handleSubmit = (e) => {
        e.preventDefault();
        navigate('/success/' + emailId);
    }

    return(<div className="container">
        <h3>Login Form</h3><hr />
        <form onSubmit={handleSubmit}>
            <div className="w-25">
                <input type="text" placeholder="Enter your email" className="form-control"
                    value={emailId} onChange={e => setEmailId(e.target.value)}></input>
            </div><br />
            <div className="w-25">
                <input type="password" placeholder="Enter your password" className="form-control"
                    value={password} onChange={e => setPassword(e.target.value)}></input>
            </div><br />
            <div>
                <input type="submit" className="btn btn-secondary" value="Login"></input>
            </div>
        </form><br />
        <div>
            <Link to = "/register">New Customer? Register</Link>
        </div>

    </div>);
}