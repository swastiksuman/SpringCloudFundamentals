import './App.css';
import { useState } from 'react';
import axios from 'axios';

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
    <div className="App">
      <button onClick={() => doTest()}>Test</button>
      <div>{ result }</div>
      <div>
        <label>First Name</label><input 
          onChange={(e)=>setFirstName(e.target.value)} type="text" />
        <label>Last Name</label><input 
          onChange={(e)=>setLastName(e.target.value)} type="text" />
        <label>Item Id</label><input 
          onChange={(e)=>setItemId(e.target.value)} type="text" />
        <button onClick={()=> placeOrder()}>Submit Order</button>
      </div>
    </div>
  );
}

export default App;
