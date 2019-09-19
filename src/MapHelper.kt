@file:JvmName("MapHelper")
import java.lang.reflect.Modifier

/**
 * This class used with Map in Kotlin @see kotlin.collections.Map or Map in Java {@link java.collections.Map},
 * you can convert the Map returned object to any Map subclass(in Java)...
 * @author Adolf(Huessien) and Mohammed
 * @since 1.0
 *
 **/

/**
 * These properties called options in the matching function (remove/return)
 * @property CONTAINS check if contain
 * @property STARTS_WITH check if start with
 * @property ENDS_WITH check if ends with
 **/
const val CONTAINS = 0
const val STARTS_WITH = 1
const val ENDS_WITH = 3
/**
 * @property TAG the tag of this class in Log
 * */
private const val TAG = "MapHelper"

/**
 * @param matchesText the text you want to check in the Key
 * @param target the Map or its subclasses remove from it you want to validate which it CharSequence key to check it
 * @param option the option of the checking in the properties above CONTAIN,STARTS_WITH or ENDS_WITH the default value is CONTAIN
 * @param ignoreCase for insensitive checking true or false to sensitive it is by default false
 * */
@JvmOverloads
fun removeAllElementsItsKey(matchesText: CharSequence, target: MutableMap<out CharSequence, *>, option: Int = CONTAINS, ignoreCase: Boolean = false) {
    require(option in 0..3) { "You should choose correct option" }
    if (target.isEmpty()) {
        println("$TAG/The Map is Empty")
        return
    }

    val iterator: Iterator<Map.Entry<CharSequence, *>> = target.entries.iterator()

    while (iterator.hasNext()) {
        val key = iterator.next().key

        when (option) {

            CONTAINS -> if (key.contains(matchesText, ignoreCase)) target.remove(key)
            STARTS_WITH -> if (key.startsWith(matchesText, ignoreCase)) target.remove(key)
            ENDS_WITH -> if (key.endsWith(matchesText, ignoreCase)) target.remove(key)
        }
    }
}
/**
 * @param matchesText the text you want to check in the Key
 * @param target the Map or its subclasses remove from it you want to validate which it CharSequence value to check it
 * @param option the option of the checking in the properties above CONTAIN,STARTS_WITH or ENDS_WITH the default value is CONTAIN
 * @param ignoreCase for insensitive checking true or false to sensitive it is by default false
 * */
@JvmOverloads
fun removeAllElementsItsValue(matchesText: CharSequence, target: MutableMap<*, out CharSequence>, option: Int = CONTAINS, ignoreCase: Boolean = false) {
    require(option in 0..3) { "You should choose correct option" }

    val iterator: Iterator<Map.Entry<*, CharSequence>> = target.entries.iterator()

    while (iterator.hasNext()) {
        val key = iterator.next().value

        when (option) {

            CONTAINS -> if (key.contains(matchesText, ignoreCase)) target.remove(key)
            STARTS_WITH -> if (key.startsWith(matchesText, ignoreCase)) target.remove(key)
            ENDS_WITH -> if (key.endsWith(matchesText, ignoreCase)) target.remove(key)
        }
    }
}
/**
 * @param matchesText the text you want to check in the Key
 * @param target the Map or its subclasses return from it you want to validate which it CharSequence value to check it
 * @param option the option of the checking in the properties above CONTAIN,STARTS_WITH or ENDS_WITH the default value is CONTAIN
 * @param ignoreCase for insensitive checking true or false to sensitive it is by default false
 * @property K the Key of the Map which has to be CharSequence or any of its subclasses which you have to choose one
 * @property V the value of the Map
 * @return MutableMap which its generics you select
 * @see returnFirstElementsItsKey
 **/
@JvmOverloads
fun <K : CharSequence, V> returnAllElementsItsKey(matchesText: CharSequence, target: MutableMap<K, V>, option: Int = CONTAINS, ignoreCase: Boolean = false): MutableMap<K, V> {
    require(option in 0..3) { "You should choose correct option" }

    val iterator: Iterator<Map.Entry<K, V>> = target.entries.iterator()

    val returnedMap = mutableMapOf<K, V>()
    while (iterator.hasNext()) {
        val key = iterator.next().key
        val value = iterator.next().value

        when (option) {

            CONTAINS -> if (key.contains(matchesText, ignoreCase)) returnedMap[key] = value
            STARTS_WITH -> if (key.startsWith(matchesText, ignoreCase)) returnedMap[key] = value
            ENDS_WITH -> if (key.endsWith(matchesText, ignoreCase)) returnedMap[key] = value
        }
    }
    return returnedMap
}
/**
 * @param matchesText the text you want to check in the Key
 * @param target the Map or its subclasses return from it you want to validate which it CharSequence value to check it
 * @param option the option of the checking in the properties above CONTAIN,STARTS_WITH or ENDS_WITH the default value is CONTAIN
 * @param ignoreCase for insensitive checking true or false to sensitive it is by default false
 * @property K the Key of the Map
 * @property V the value of the Map which has to be CharSequence or any of its subclasses which you have to choose one
 * @return MutableMap which its generics you select
 * @see returnFirstElementsItsValue
 **/
@JvmOverloads
fun <K, V:CharSequence> returnAllElementsItsValue(matchesText: CharSequence, target: MutableMap<K, V>, option: Int = CONTAINS, ignoreCase: Boolean = false): MutableMap<K, V> {
    require(option in 0..3) { "You should choose correct option" }

    val iterator: Iterator<Map.Entry<K, V>> = target.entries.iterator()

    val returnedMap = mutableMapOf<K, V>()
    while (iterator.hasNext()) {
        val key = iterator.next().key
        val value = iterator.next().value

        when (option) {

            CONTAINS -> if (value.contains(matchesText, ignoreCase)) returnedMap[key] = value
            STARTS_WITH -> if (value.startsWith(matchesText, ignoreCase)) returnedMap[key] = value
            ENDS_WITH -> if (value.endsWith(matchesText, ignoreCase)) returnedMap[key] = value
        }
    }
    return returnedMap
}

/**
 * @param matchesText the text you want to check in the Key
 * @param target the Map or its subclasses return from it you want to validate which it CharSequence value to check it
 * @param option the option of the checking in the properties above CONTAIN,STARTS_WITH or ENDS_WITH the default value is CONTAIN
 * @param ignoreCase for insensitive checking true or false to sensitive it is by default false
 * @property K the Key of the Map which has to be CharSequence or any of its subclasses which you have to choose one
 * @property V the value of the Map
 * @return MutableMap which its generics you select
 * @see returnAllElementsItsKey
 **/
@JvmOverloads
fun <K : CharSequence, V> returnFirstElementsItsKey(matchesText: CharSequence, target: MutableMap<K, V>, option: Int = CONTAINS, ignoreCase: Boolean = false): MutableMap<K, V> {
    require(option in 0..3) { "You should choose correct option" }

    val iterator: Iterator<Map.Entry<K, V>> = target.entries.iterator()

    val returnedMap = mutableMapOf<K, V>()

    whiled@ while (iterator.hasNext()) {
        val key = iterator.next().key
        val value = iterator.next().value

        when (option) {

            CONTAINS -> {
                if (key.contains(matchesText, ignoreCase)) returnedMap[key] = value
                break@whiled
            }
            STARTS_WITH -> {
                if (key.startsWith(matchesText, ignoreCase)) returnedMap[key] = value
                break@whiled
            }
            ENDS_WITH -> {
                if (key.endsWith(matchesText, ignoreCase)) returnedMap[key] = value
                break@whiled
            }

        }

    }
    return returnedMap
}
/**
 * @param matchesText the text you want to check in the Key
 * @param target the Map or its subclasses return from it you want to validate which it CharSequence value to check it
 * @param option the option of the checking in the properties above CONTAIN,STARTS_WITH or ENDS_WITH the default value is CONTAIN
 * @param ignoreCase for insensitive checking true or false to sensitive it is by default false
 * @property K the Key of the Map
 * @property V the value of the Map which has to be CharSequence or any of its subclasses which you have to choose one
 * @return MutableMap which its generics you select
 * @see returnAllElementsItsValue
 **/
@JvmOverloads
fun <K, V : CharSequence> returnFirstElementsItsValue(matchesText: CharSequence, target: MutableMap<K, V>, option: Int = CONTAINS, ignoreCase: Boolean = false): MutableMap<K, V> {
    require(option in 0..3) { "You should choose correct option" }

    val iterator: Iterator<Map.Entry<K, V>> = target.entries.iterator()

    val returnedMap = mutableMapOf<K, V>()

    whiled@ while (iterator.hasNext()) {
        val key = iterator.next().key
        val value = iterator.next().value

        when (option) {

            CONTAINS -> {
                if (value.contains(matchesText, ignoreCase)) returnedMap[key] = value
                break@whiled
            }
            STARTS_WITH -> {
                if (value.startsWith(matchesText, ignoreCase)) returnedMap[key] = value
                break@whiled
            }
            ENDS_WITH -> {
                if (value.endsWith(matchesText, ignoreCase)) returnedMap[key] = value
                break@whiled
            }

        }

    }
    return returnedMap
}
/**
 * This method convert the Object of any class to Map object that the key is the Field name
 * and the Value is the value of that Field make sure you make one of these option to save your
 * object first one to make public getter and the second make a public field
 * This method use [java.lang.reflect] package to achieve that
 * @param targetObject the object you want to convert to Map object
 * @return MutableMap that store the object info
 * @see convertMapToObject
 * */
fun convertObjectToMap(targetObject: Any): MutableMap<String, Any?> {

    val returnedMap = mutableMapOf<String, Any?>()

    val fields = targetObject.javaClass.declaredFields
    val methods = targetObject.javaClass.declaredMethods
    println("$TAG/fields number = ${fields.size} and methods number = ${methods.size}")

    var counter = 0
    while (counter < fields.size) {
        val field = fields[counter]
        if (Modifier.isPublic(field.modifiers)) {

            when (val obj = field.get(targetObject)) {
                is Number -> returnedMap[field.name] = obj
                is CharSequence -> returnedMap[field.name] = obj.toString()
                is Any -> returnedMap[field.name] = convertObjectToMap(obj)
                else -> println("$TAG/This field ${field.name} can not be entered")
            }
        } else if (field.name != "sizeTable" && field.name != "DigitTens" && field.name != "field digits") {
            returnedMap[field.name] = null

            for (method in methods) {

                if (method.name.equals("get${field.name}", true)) {
                    println("I am here")
                    returnedMap[field.name] = method.invoke(targetObject)
                    break
                }
            }
            if (returnedMap[field.name] == null)
                println("$TAG/No getter for this private field ${field.name}")
        }
        counter++
    }
    return returnedMap
}
//TODO remove the returnedObject and replace it by targetObject
/**
 * This method convert Map object to object of class you want rely on the info in that Map object
 * DO NOT FORGET TO MAKE AN EMPTY CONSTRUCTOR IN THAT CLASS YOU WANT TO MAKE OBJECT FROM
 * @param targetObject object of class you want object from you can initialize it to empty constructor
 * because it used to get the methods/fields of that class to append the value in returned object
 * @return MutableMap that store the object info
 * @see convertObjectToMap
 * */
@Suppress("UNCHECKED_CAST")
fun <T> convertMapToObject(targetObject: Any, targetMap: Map<String, Any?>): T {

    val returnObject = targetObject.javaClass.newInstance() as T
    var counter = 0
    while (counter < targetObject.javaClass.declaredFields.size) {

        val field = targetObject.javaClass.declaredFields[counter]
        if (!Modifier.isFinal(field.modifiers)) {
            println("$TAG/The field ${field.name} is not final")
            val obj = targetMap[field.name]
            if (Modifier.isPublic(field.modifiers)) {
                println("$TAG/The field ${field.name} is Public")
                println("The field ${field.name} is ${obj?.javaClass?.name}")
                if (obj !is Map<*, *>) {
                    field.set(returnObject, obj)
                } else {
                    println("${obj.javaClass} is the java class")
                    field.set(returnObject, convertMapToObject(field.type.newInstance(), (obj as Map<String, Any?>)))
                }
            } else {

                for (method in targetObject.javaClass.declaredMethods) {

                    if (method.name.equals("set${field.name}", true)) {

                        val temp = targetMap[field.name]
                        println("The private field name is -> ${field.name}")
                        method.invoke(returnObject, temp)
                        break
                    }
                }

            }
        } else {
            println("$TAG/The field ${field.name} is Final and can not reassign")
        }
        counter++
    }
    return returnObject
}

private val childSpace = StringBuilder()
private val parentSpace = StringBuilder()
/**
 * This method used to print the Map object
 * @param map the Map object you want to print
 * */
fun printMap(map: Map<*, *>) {

    parentSpace.append(childSpace)
    childSpace.append("------>")

    for (entry in map.entries) {

        print("\n${parentSpace}${entry.key}\n")
        val value = entry.value

        if (value is Map<*, *>) {
            printMap(value)
            childSpace.delete(childSpace.length-7,childSpace.length)
            parentSpace.delete(parentSpace.length-7,parentSpace.length)

        } else {
            println("$childSpace $value")
        }

    }

}
