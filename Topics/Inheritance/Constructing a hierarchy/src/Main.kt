open class Animal()
open class Fish(): Animal()
open class Mammal(): Animal()
class Lion(): Mammal()
class Salmon(): Fish()
class Carp(): Fish()
open class Bird(): Animal()
class Eagle(): Bird()