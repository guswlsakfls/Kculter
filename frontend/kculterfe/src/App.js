import React from 'react';
import { BrowserRouter,Routes, Route } from 'react-router-dom';
import NavBar from './navbar/NavBar';
import Login from './login/Login';
import MainPage from './main/MainPage';

function App() {
  return (
    <BrowserRouter>
      <NavBar/>
      <Routes>
        <Route path="/login" element={<Login/>}></Route>
        <Route path="/" element={<MainPage/>}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
