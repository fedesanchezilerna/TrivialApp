package org.ilerna.trivialapp.model

/**
 * Object that provides trivia questions.
 */
object QuestionProvider {
    
    private val questions = listOf(
        // EASY QUESTIONS (1-10)
        Question(
            id = 1,
            questionText = "¿Cuál es el planeta más grande del sistema solar?",
            options = listOf("Saturno", "Júpiter", "Neptuno", "Tierra"),
            correctAnswerIndex = 1,
            difficulty = "Easy"
        ),
        Question(
            id = 2,
            questionText = "¿Cuántos planetas hay en nuestro sistema solar?",
            options = listOf("7", "8", "9", "10"),
            correctAnswerIndex = 1,
            difficulty = "Easy"
        ),
        Question(
            id = 3,
            questionText = "¿Cuál es la estrella más cercana a la Tierra?",
            options = listOf("Proxima Centauri", "El Sol", "Sirio", "Vega"),
            correctAnswerIndex = 1,
            difficulty = "Easy"
        ),
        Question(
            id = 4,
            questionText = "¿Qué planeta es conocido como el 'planeta rojo'?",
            options = listOf("Venus", "Júpiter", "Marte", "Saturno"),
            correctAnswerIndex = 2,
            difficulty = "Easy"
        ),
        Question(
            id = 5,
            questionText = "¿Cuál es el satélite natural de la Tierra?",
            options = listOf("Europa", "Titán", "La Luna", "Fobos"),
            correctAnswerIndex = 2,
            difficulty = "Easy"
        ),
        Question(
            id = 6,
            questionText = "¿Cuál es el planeta más cercano al Sol?",
            options = listOf("Venus", "Mercurio", "Tierra", "Marte"),
            correctAnswerIndex = 1,
            difficulty = "Easy"
        ),
        Question(
            id = 7,
            questionText = "¿Cómo se llama nuestra galaxia?",
            options = listOf("Andrómeda", "Vía Láctea", "Galaxia Remolino", "Galaxia Sombrero"),
            correctAnswerIndex = 1,
            difficulty = "Easy"
        ),
        Question(
            id = 8,
            questionText = "¿Cuál es el planeta con los anillos más visibles?",
            options = listOf("Júpiter", "Urano", "Saturno", "Neptuno"),
            correctAnswerIndex = 2,
            difficulty = "Easy"
        ),
        Question(
            id = 9,
            questionText = "¿Qué es una supernova?",
            options = listOf("Un planeta nuevo", "Una estrella que explota", "Un cometa", "Un asteroide"),
            correctAnswerIndex = 1,
            difficulty = "Easy"
        ),
        Question(
            id = 10,
            questionText = "¿Cuál es el planeta más frío del sistema solar?",
            options = listOf("Plutón", "Neptuno", "Urano", "Júpiter"),
            correctAnswerIndex = 2,
            difficulty = "Easy"
        ),
        
        // MEDIUM QUESTIONS (11-20)
        Question(
            id = 11,
            questionText = "¿Cuánto tiempo tarda la luz del Sol en llegar a la Tierra?",
            options = listOf("8 minutos", "1 hora", "1 día", "1 segundo"),
            correctAnswerIndex = 0,
            difficulty = "Medium"
        ),
        Question(
            id = 12,
            questionText = "¿Cuál es la velocidad de la luz en el vacío?",
            options = listOf("300,000 km/s", "150,000 km/s", "500,000 km/s", "100,000 km/s"),
            correctAnswerIndex = 0,
            difficulty = "Medium"
        ),
        Question(
            id = 13,
            questionText = "¿Cuál es el nombre de la teoría que explica el origen del universo?",
            options = listOf("Teoría Cuántica", "Big Bang", "Relatividad", "Evolución Estelar"),
            correctAnswerIndex = 1,
            difficulty = "Medium"
        ),
        Question(
            id = 14,
            questionText = "¿Cuántas lunas tiene Júpiter aproximadamente?",
            options = listOf("12", "45", "79", "120"),
            correctAnswerIndex = 2,
            difficulty = "Medium"
        ),
        Question(
            id = 15,
            questionText = "¿Qué es un agujero negro?",
            options = listOf("Un planeta oscuro", "Una región con gravedad extrema", "Una nebulosa", "Un cometa"),
            correctAnswerIndex = 1,
            difficulty = "Medium"
        ),
        Question(
            id = 16,
            questionText = "¿Cuál es la galaxia más cercana a la Vía Láctea?",
            options = listOf("Galaxia del Triángulo", "Andrómeda", "Galaxia Remolino", "Centaurus A"),
            correctAnswerIndex = 1,
            difficulty = "Medium"
        ),
        Question(
            id = 17,
            questionText = "¿Qué es un año luz?",
            options = listOf("365 días en el espacio", "Una medida de tiempo", "Una medida de distancia", "La edad del universo"),
            correctAnswerIndex = 2,
            difficulty = "Medium"
        ),
        Question(
            id = 18,
            questionText = "¿Cuál es la temperatura aproximada en el núcleo del Sol?",
            options = listOf("1 millón °C", "15 millones °C", "100 millones °C", "1000 °C"),
            correctAnswerIndex = 1,
            difficulty = "Medium"
        ),
        Question(
            id = 19,
            questionText = "¿Qué elemento es más abundante en el universo?",
            options = listOf("Oxígeno", "Carbono", "Hidrógeno", "Helio"),
            correctAnswerIndex = 2,
            difficulty = "Medium"
        ),
        Question(
            id = 20,
            questionText = "¿Cuál es el nombre del telescopio espacial más famoso?",
            options = listOf("Kepler", "Hubble", "Spitzer", "Chandra"),
            correctAnswerIndex = 1,
            difficulty = "Medium"
        ),
        
        // HARD QUESTIONS (21-30)
        Question(
            id = 21,
            questionText = "¿Cuál es la edad aproximada del universo?",
            options = listOf("13.8 mil millones de años", "4.6 mil millones de años", "20 mil millones de años", "1 mil millones de años"),
            correctAnswerIndex = 0,
            difficulty = "Hard"
        ),
        Question(
            id = 22,
            questionText = "¿Qué porcentaje del universo está compuesto por materia oscura?",
            options = listOf("15%", "27%", "50%", "85%"),
            correctAnswerIndex = 1,
            difficulty = "Hard"
        ),
        Question(
            id = 23,
            questionText = "¿Cuál es el nombre de la fuerza que acelera la expansión del universo?",
            options = listOf("Gravedad cuántica", "Energía oscura", "Fuerza nuclear fuerte", "Radiación cósmica"),
            correctAnswerIndex = 1,
            difficulty = "Hard"
        ),
        Question(
            id = 24,
            questionText = "¿Cuál es el límite de Chandrasekhar?",
            options = listOf("La masa máxima de una enana blanca", "La velocidad de escape de un agujero negro", "El tamaño mínimo de una estrella", "La distancia al horizonte cósmico"),
            correctAnswerIndex = 0,
            difficulty = "Hard"
        ),
        Question(
            id = 25,
            questionText = "¿Qué son las ondas gravitacionales?",
            options = listOf("Ondas de radio del espacio", "Perturbaciones en el espacio-tiempo", "Radiación electromagnética", "Partículas subatómicas"),
            correctAnswerIndex = 1,
            difficulty = "Hard"
        ),
        Question(
            id = 26,
            questionText = "¿Cuál es la constante de Hubble aproximadamente?",
            options = listOf("70 km/s/Mpc", "300 km/s/Mpc", "150 km/s/Mpc", "500 km/s/Mpc"),
            correctAnswerIndex = 0,
            difficulty = "Hard"
        ),
        Question(
            id = 27,
            questionText = "¿Qué es la nucleosíntesis primordial?",
            options = listOf("La formación de planetas", "La creación de elementos ligeros tras el Big Bang", "La fusión en el núcleo estelar", "La formación de galaxias"),
            correctAnswerIndex = 1,
            difficulty = "Hard"
        ),
        Question(
            id = 28,
            questionText = "¿Cuál es la temperatura de la radiación cósmica de fondo?",
            options = listOf("3 K", "2.7 K", "5 K", "1 K"),
            correctAnswerIndex = 1,
            difficulty = "Hard"
        ),
        Question(
            id = 29,
            questionText = "¿Qué es un magnetar?",
            options = listOf("Un tipo de agujero negro", "Una estrella de neutrones con campo magnético extremo", "Un planeta magnético", "Una galaxia activa"),
            correctAnswerIndex = 1,
            difficulty = "Hard"
        ),
        Question(
            id = 30,
            questionText = "¿Cuál es la paradoja de Fermi?",
            options = listOf("La expansión acelerada del universo", "La ausencia de evidencia de vida extraterrestre", "La materia oscura invisible", "La curvatura del espacio-tiempo"),
            correctAnswerIndex = 1,
            difficulty = "Hard"
        )
    )

    /**
     * Get all trivia questions.
     */
    fun getAllQuestions(): List<Question> {
        return questions
    }

    /**
     * Get trivia questions by difficulty.
     */
    fun getQuestionsByDifficulty(difficulty: String): List<Question> {
        return questions.filter { it.difficulty == difficulty }
    }
    
    /**
     * Get a specified number of random trivia questions.
     */
    fun getRandomQuestions(count: Int = 10): List<Question> {
        return questions.shuffled().take(count)
    }
    
    /**
     * Get a specified number of random trivia questions by difficulty.
     */
    fun getQuestionsByDifficultyRandomized(difficulty: String, count: Int = 10): List<Question> {
        return questions.filter { it.difficulty == difficulty }.shuffled().take(count)
    }
}