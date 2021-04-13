import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Jumbotron from 'react-bootstrap/Jumbotron';
import Home from './home/Home';

function App() {

  return (
    <div>
      <Jumbotron>
        <h1>Kharido</h1>
        <p>
          Buy Phones at the cheapest prices.
        </p>
        <p>
        </p>
      </Jumbotron>
      <Home></Home>
    </div>
  );
}

export default App;
