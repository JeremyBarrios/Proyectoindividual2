import axios from 'axios';

const API_URL = 'http://localhost:8080/api/estudiantes';

const obtenerEstudiantes = () => {
    return axios.get(API_URL);
};

const agregarEstudiante = (estudiante) => {
    return axios.post(API_URL, estudiante);
};

const EstudianteService = {
    obtenerEstudiantes,
    agregarEstudiante,
};

export default EstudianteService;
