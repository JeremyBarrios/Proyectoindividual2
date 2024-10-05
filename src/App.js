import React from 'react';
import './App.css';
import Estudiantes from './Estudiantes';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Aplicación de Gestión de Notas</h1>
      </header>
      <main>
        <Estudiantes />
      </main>
    </div>
  );
}

export default App;
