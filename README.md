#Use case: Memberikan Peringatan - Oleh Admin
Design Pattern & Deployment Awal - 17 April 2024
Use case ini menggunakan design pattern yaitu "State Design Pattern"
State design pattern cocok untuk digunakan di use case ini dikarenakan meng-adopsi prinsip encapsulation dari sebuah behavior.
Adanya kemiripan dengan prinsip finite state machine, ia enkapsulasi objek-objek ke state yang spesifik, jadi logic akan lebih terorganisir, lebih mudah untuk dimodifikasi pula.
#Behavior yang terpisah
- **Normal State**: Initial state.
- **First Warning State**: State setelah warning pertama.
- **Second Warning State**:State setelah warning kedua, jika pelanggan dapat warning ketiga, state akan berpindah.
- **Blocked State**: Pelanggan dengan 3 warning akan di-blok akunnya (akun menjadi inactive).


