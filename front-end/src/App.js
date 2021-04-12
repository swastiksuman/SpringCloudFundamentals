import './App.css';
import { useState } from 'react';
import axios from 'axios';
import Jumbotron from 'react-bootstrap/Jumbotron';
import Button from 'react-bootstrap/Button';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {

  const [result, setResult] = useState(null);
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [itemId, setItemId] = useState('');


  function doTest(){
    axios.get('http://localhost:8080/doTransaction')
      .then(res =>{
        console.log(res);
        setResult(res.data);
      }
      );
    console.log('***Test***');
  }

  function placeOrder(){
    const placeOrder = {
        firstName: "Soujanya",
        lastName: "Talla",
        itemId: "123"
      };
    axios.post('http://localhost:8080/placeOrder', {
      firstName: firstName,
      lastName: lastName,
      itemId:  itemId
    })
      .then(response => console.log(response));
  }

  return (
    <div>
      <Jumbotron>
        <h1>Hello, world!</h1>
        <p>
          This is a simple hero unit, a simple jumbotron-style component for calling
          extra attention to featured content or information.
        </p>
        <p>
          <Button variant="primary">Learn more</Button>
        </p>
      </Jumbotron>
      <Button variant="outline-primary" onClick={() => doTest()}>Test</Button>
      <div>{ result }</div>
      <div>
        <label>First Name</label><input 
          onChange={(e)=>setFirstName(e.target.value)} type="text" />
        <label>Last Name</label><input 
          onChange={(e)=>setLastName(e.target.value)} type="text" />
        <label>Item Id</label><input 
          onChange={(e)=>setItemId(e.target.value)} type="text" />
        <Button variant="primary" onClick={()=> placeOrder()}>Submit Order</Button>
      </div>
    </div>
  );
}

export default App;
