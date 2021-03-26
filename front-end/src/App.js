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

  function doTransaction(){

  }
  return (
    <div className="App">
      <button onClick={() => doTest()}>Test</button>
      <div>{ result }</div>
    </div>
  );
}

export default App;
