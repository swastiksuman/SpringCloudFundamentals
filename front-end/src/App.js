import './App.css';
import { useState } from 'react';
import axios from 'axios';

function App() {

  const [result, setResult] = useState(null);

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
    axios.post('http://localhost:8080/placeOrder', placeOrder)
      .then(response => console.log(response));
  }

  return (
    <div className="App">
      <button onClick={() => doTest()}>Test</button>
      <div>{ result }</div>
      <div>
        <label>First Name</label><input type="text" />
        <label>Last Name</label><input type="text" />
        <label>Item Id</label><input type="text" />
        <button onClick={()=> placeOrder()}>Submit Order</button>
      </div>
    </div>
  );
}

export default App;
