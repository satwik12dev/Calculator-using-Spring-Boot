import { useState, useEffect } from "react";
import "./App.css";

function App() {

  const [display, setDisplay] = useState("");
  const [a, setA] = useState(null);
  const [operation, setOperation] = useState("");

  const toggleTheme = () => {
    document.body.classList.toggle("light");
  };

  const handleNumber = (num) => {
    setDisplay(prev => prev + num);
  };

  const handleDecimal = () => {
    if(!display.includes(".")){
      setDisplay(prev => prev + ".");
    }
  };

  const handleOperation = (op) => {
    if(display === "") return;
    setA(display);
    setDisplay("");
    setOperation(op);
  };

  const calculate = async () => {

    if(a === null || display === "") return;

    const b = display;

    try{

      const res = await fetch(`https://spring-calculator-api-1.onrender.com/api/${operation}?a=${a}&b=${b}`);
      const data = await res.json();

      if(data.message && !data.message.toLowerCase().includes("successful")){
        setDisplay("Error");
        alert(data.message);
      }else{
        setDisplay(data.result.toString());
      }

    }catch{
      setDisplay("Error");
    }

  };

  const clear = () => {
    setDisplay("");
    setA(null);
    setOperation("");
  };
  useEffect(() => {

  const handleKeyPress = (e) => {

    if(!isNaN(e.key)) handleNumber(e.key);

    if(e.key === ".") handleDecimal();

    if(e.key === "+") handleOperation("add");
    if(e.key === "-") handleOperation("sub");
    if(e.key === "*") handleOperation("mul");
    if(e.key === "/") handleOperation("div");
    if(e.key === "%") handleOperation("mod");

    if(e.key === "Enter") calculate();

    if(e.key === "Backspace"){
      setDisplay(prev => prev.slice(0,-1));
    }

    if(e.key === "Delete"){
      clear();
    }

  };

  window.addEventListener("keydown",handleKeyPress);

  return () => {
    window.removeEventListener("keydown",handleKeyPress);
  };

},[display]);

  return (

    <div className="app">

      <div className="theme-switch">

        <input type="checkbox" id="theme-toggle" onChange={toggleTheme} />

        <label htmlFor="theme-toggle" className="toggle-label">
          <span className="sun">☀</span>
          <span className="moon">🌙</span>
          <span className="ball"></span>
        </label>

      </div>

      <div className="calculator">

        <div className="display">
          {display || "0"}
        </div>

        <div className="buttons">

          <button className="clear" onClick={clear}>C</button>
          <button className="op" onClick={()=>handleOperation("mod")}>%</button>
          <button className="op" onClick={()=>handleOperation("div")}>÷</button>
          

          <button onClick={()=>handleNumber("7")}>7</button>
          <button onClick={()=>handleNumber("8")}>8</button>
          <button onClick={()=>handleNumber("9")}>9</button>
          <button className="op" onClick={()=>handleOperation("mul")}>×</button>
          

          <button onClick={()=>handleNumber("4")}>4</button>
          <button onClick={()=>handleNumber("5")}>5</button>
          <button onClick={()=>handleNumber("6")}>6</button>
          <button className="op" onClick={()=>handleOperation("sub")}>−</button>

          <button onClick={()=>handleNumber("1")}>1</button>
          <button onClick={()=>handleNumber("2")}>2</button>
          <button onClick={()=>handleNumber("3")}>3</button>
          <button className="op" onClick={()=>handleOperation("add")}>+</button>
          <button className="zero" onClick={()=>handleNumber("0")}>0</button>
           <button className="decimal" onClick={()=>handleDecimal(".")}>.</button>
          <button className="equal" onClick={calculate}>calc</button>
          
         
          

        </div>

      </div>

    </div>

  );

}

export default App;