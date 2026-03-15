import { useState } from "react";
import "./App.css";

function App() {

  const [display, setDisplay] = useState("");
  const [a, setA] = useState(null);
  const [operation, setOperation] = useState("");

  const handleNumber = (num) => {
    setDisplay(display + num);
  };

  const handleOperation = (op) => {
    setA(display);
    setDisplay("");
    setOperation(op);
  };

  const calculate = async () => {

    if (!a || !display) return;

    const b = display;

    const res = await fetch(`http://localhost:8080/api/${operation}?a=${a}&b=${b}`);
    const data = await res.json();

    setDisplay(data.result);
  };

  const clear = () => {
    setDisplay("");
    setA(null);
    setOperation("");
  };

  return (
    <div className="app">

      <div className="calculator">

        <div className="display">
          {display || "0"}
        </div>

        <div className="buttons">

          <button className="clear" onClick={clear}>C</button>
          <button onClick={()=>handleOperation("div")}>÷</button>
          <button onClick={()=>handleOperation("mul")}>×</button>
          <button onClick={()=>handleOperation("sub")}>−</button>

          <button onClick={()=>handleNumber("7")}>7</button>
          <button onClick={()=>handleNumber("8")}>8</button>
          <button onClick={()=>handleNumber("9")}>9</button>
          <button className="op" onClick={()=>handleOperation("add")}>+</button>

          <button onClick={()=>handleNumber("4")}>4</button>
          <button onClick={()=>handleNumber("5")}>5</button>
          <button onClick={()=>handleNumber("6")}>6</button>

          <button onClick={()=>handleNumber("1")}>1</button>
          <button onClick={()=>handleNumber("2")}>2</button>
          <button onClick={()=>handleNumber("3")}>3</button>

          <button className="zero" onClick={()=>handleNumber("0")}>0</button>
          <button className="equal" onClick={calculate}>=</button>

        </div>

      </div>

    </div>
  );
}

export default App;