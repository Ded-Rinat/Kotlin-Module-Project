class Notes : Diary() {
    private fun addNote() {
        println("Введите наименование заметки")
        val read1 = readLine()!!
        println("Введите текст заметки")
        val read2 = readLine()!!
        println("Заметка сохранена")
        val newNote = Note(read1, read2)
        noteText[(noteText.size + 1)] = newNote
    }
    override fun teams() {
        for (note in 1..noteText.size) {
            val str = noteText[note]?.name
            println("$note. $str")
        }
    }
    override fun printing() {
        while (true) {
            println("Список заметок")
            println("0. Создать заметку")
            menuNumb = noteText.size + 1
            if (noteText.isNotEmpty()) teams()
            println("${menuNumb}. Возвратиться в меню архивов")
            choice = diarysReader()
            when (choice) {
                0 -> addNote()
                menuNumb -> return
                else -> if (noteText.contains(choice)) {
                    println("Содержимое заметки:")
                    println(noteText[choice]?.noteText)
                } else println("Error! Позиции с таким номером нет. Выберете пункт из меню")
            }
        }
    }
}