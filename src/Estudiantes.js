import React, { useEffect, useState } from 'react';
import EstudianteService from './services/estudianteService';

const Estudiantes = () => {
    const [estudiantes, setEstudiantes] = useState([]);
    const [nombre, setNombre] = useState('');
    const [apellidos, setApellidos] = useState('');
    const [actividades, setActividades] = useState(0);
    const [primerParcial, setPrimerParcial] = useState(0);
    const [segundoParcial, setSegundoParcial] = useState(0);
    const [examenFinal, setExamenFinal] = useState(0);

    useEffect(() => {
        obtenerEstudiantes();
    }, []);

    const obtenerEstudiantes = async () => {
        try {
            const response = await EstudianteService.obtenerEstudiantes();
            setEstudiantes(response.data);
        } catch (error) {
            console.error("Error al obtener estudiantes", error);
        }
    };

    const agregarEstudiante = async (e) => {
        e.preventDefault();
        const nuevoEstudiante = { nombre, apellidos, actividades, primerParcial, segundoParcial, examenFinal };
        try {
            await EstudianteService.agregarEstudiante(nuevoEstudiante);
            obtenerEstudiantes(); // Refrescar la lista de estudiantes
            limpiarFormulario();
        } catch (error) {
            console.error("Error al agregar estudiante", error);
        }
    };

    const limpiarFormulario = () => {
        setNombre('');
        setApellidos('');
        setActividades(0);
        setPrimerParcial(0);
        setSegundoParcial(0);
        setExamenFinal(0);
    };

    return (
        <div>
            <h1>Gestión de Estudiantes</h1>
            <form onSubmit={agregarEstudiante}>
                <input
                    type="text"
                    placeholder="Nombre"
                    value={nombre}
                    onChange={(e) => setNombre(e.target.value)}
                    required
                />
                <input
                    type="text"
                    placeholder="Apellidos"
                    value={apellidos}
                    onChange={(e) => setApellidos(e.target.value)}
                    required
                />
                <input
                    type="number"
                    placeholder="Actividades (Máx. 35)"
                    value={actividades}
                    onChange={(e) => setActividades(Number(e.target.value))}
                    required
                />
                <input
                    type="number"
                    placeholder="Primer Parcial (Máx. 15)"
                    value={primerParcial}
                    onChange={(e) => setPrimerParcial(Number(e.target.value))}
                    required
                />
                <input
                    type="number"
                    placeholder="Segundo Parcial (Máx. 15)"
                    value={segundoParcial}
                    onChange={(e) => setSegundoParcial(Number(e.target.value))}
                    required
                />
                <input
                    type="number"
                    placeholder="Examen Final (Máx. 35)"
                    value={examenFinal}
                    onChange={(e) => setExamenFinal(Number(e.target.value))}
                    required
                />
                <button type="submit">Agregar Estudiante</button>
            </form>

            <h2>Lista de Estudiantes</h2>
            <ul>
                {estudiantes.map((estudiante) => (
                    <li key={estudiante.id}>
                        {estudiante.nombre} {estudiante.apellidos} - 
                        Actividades: {estudiante.actividades}, 
                        Primer Parcial: {estudiante.primerParcial}, 
                        Segundo Parcial: {estudiante.segundoParcial}, 
                        Examen Final: {estudiante.examenFinal}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Estudiantes;
