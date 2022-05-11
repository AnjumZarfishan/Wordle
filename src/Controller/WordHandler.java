package Controller;

import Model.WordsModel;
import Model.StatusWorlde;
import java.util.Random;
 
public class WordHandler {
    private static String currentWordObject;
    
    public static String randomWordGenerater() {
        Random randObject = new Random();
        String randomWordObject = WordsModel.list.get(randObject.nextInt(WordsModel.list.size()));
        currentWordObject = randomWordObject;
        return randomWordObject;
    }
    
    public static StatusWorlde checkIndexWorld(String enteredWordObject, int currentColumnObject) {
        if (currentWordObject.charAt(currentColumnObject) == (enteredWordObject.charAt(currentColumnObject))) {
            return StatusWorlde.CORRECTBLOCK;
        } else if (currentWordObject.contains(Character.toString(enteredWordObject.charAt(currentColumnObject)))) {
            if (currentWordObject.substring(currentWordObject.indexOf(Character.toString(
                    enteredWordObject.charAt(currentColumnObject))) + 1, enteredWordObject.length()).contains(
                        Character.toString(enteredWordObject.charAt(currentColumnObject)))) {
                if (enteredWordObject.substring(0, currentColumnObject).contains(
                        Character.toString(enteredWordObject.charAt(currentColumnObject)))) {
                    if (enteredWordObject.substring(enteredWordObject.substring(0, currentColumnObject).indexOf(
                            Character.toString(enteredWordObject.charAt(currentColumnObject))) + 1, currentColumnObject).contains(
                            Character.toString(enteredWordObject.charAt(currentColumnObject)))) {
                        return StatusWorlde.WRONGBLOCK;
                    } else if (enteredWordObject.substring(currentColumnObject + 1, enteredWordObject.length()).contains(
                            Character.toString(enteredWordObject.charAt(currentColumnObject)))) {
                        int index1Object = enteredWordObject.substring(currentColumnObject + 1, enteredWordObject.length()).indexOf(
                                Character.toString(enteredWordObject.charAt(currentColumnObject))) + (currentColumnObject + 1);
                        if (enteredWordObject.substring(index1Object + 1, enteredWordObject.length()).contains(
                                Character.toString(enteredWordObject.charAt(currentColumnObject)))) {
                            int index2Object = enteredWordObject.substring(index1Object + 1, enteredWordObject.length()).indexOf(
                                    Character.toString(enteredWordObject.charAt(currentColumnObject))) + index1Object;
                            if (enteredWordObject.substring(index2Object + 1, enteredWordObject.length()).contains(
                                    Character.toString(enteredWordObject.charAt(currentColumnObject)))) {
                                return StatusWorlde.WRONGBLOCK;
                            } else {
                                if (enteredWordObject.charAt(index1Object) == currentWordObject.charAt(index1Object)
                                    || enteredWordObject.charAt(index2Object) == currentWordObject.charAt(index2Object)) {
                                    return StatusWorlde.WRONGBLOCK;
                                } else {
                                    return StatusWorlde.SIMILARBLOCK;
                                }
                            }
                        } else {
                            if (enteredWordObject.charAt(index1Object) == currentWordObject.charAt(index1Object)) {
                                return StatusWorlde.WRONGBLOCK;
                            } else {
                                return StatusWorlde.SIMILARBLOCK;
                            }
                        }
                    } else {
                        return StatusWorlde.SIMILARBLOCK;
                    }
                } else if (enteredWordObject.substring(currentColumnObject + 1, enteredWordObject.length()).contains(
                        Character.toString(enteredWordObject.charAt(currentColumnObject)))) {
                    return checkIndexShortWord(enteredWordObject, currentColumnObject);
                } else {
                    return StatusWorlde.SIMILARBLOCK;
                }
            } else if (enteredWordObject.substring(0, currentColumnObject).contains(
                Character.toString(enteredWordObject.charAt(currentColumnObject)))) {
                return StatusWorlde.WRONGBLOCK;
            } else if (enteredWordObject.substring(currentColumnObject + 1, enteredWordObject.length()).contains(
                    Character.toString(enteredWordObject.charAt(currentColumnObject)))) {
                int index1Object = enteredWordObject.substring(currentColumnObject + 1, enteredWordObject.length()).indexOf(
                        Character.toString(enteredWordObject.charAt(currentColumnObject))) + (currentColumnObject + 1);
                if (enteredWordObject.charAt(index1Object) == currentWordObject.charAt(index1Object)) {
                    return StatusWorlde.WRONGBLOCK;
                } else if (enteredWordObject.substring((currentColumnObject < 4 ? currentColumnObject + 2 : 5),
                    enteredWordObject.length()).contains(Character.toString(enteredWordObject.charAt(currentColumnObject)))) {
                    int index2Object = enteredWordObject.substring(currentColumnObject + 2, enteredWordObject.length()).indexOf(
                            Character.toString(enteredWordObject.charAt(currentColumnObject))) + (currentColumnObject + 2);
                    if (enteredWordObject.charAt(index2Object) == currentWordObject.charAt(index2Object)) {
                        return StatusWorlde.WRONGBLOCK;
                    } else if (enteredWordObject.substring((currentColumnObject < 3 ? currentColumnObject + 3 : 5),
                        enteredWordObject.length()).contains(Character.toString(enteredWordObject.charAt(currentColumnObject)))) {
                        int index3Object = enteredWordObject.substring(currentColumnObject + 3, enteredWordObject.length()).indexOf(
                            Character.toString(enteredWordObject.charAt(currentColumnObject))) + (currentColumnObject + 3);
                        if (enteredWordObject.charAt(index3Object) == currentWordObject.charAt(index3Object)) {
                            return StatusWorlde.WRONGBLOCK;
                        } else if (enteredWordObject.substring((currentColumnObject < 2 ? currentColumnObject + 4 : 5),
                            enteredWordObject.length()).contains(Character.toString(enteredWordObject.charAt(currentColumnObject)))) {
                            int index4Object = enteredWordObject.substring(currentColumnObject + 4, enteredWordObject.length()).indexOf(
                                    Character.toString(enteredWordObject.charAt(currentColumnObject))) + (currentColumnObject + 4);
                            if (enteredWordObject.charAt(index4Object) == currentWordObject.charAt(index4Object)) {
                                return StatusWorlde.WRONGBLOCK;
                            } else {
                                return StatusWorlde.SIMILARBLOCK;
                            }
                        } else {
                            return StatusWorlde.SIMILARBLOCK;
                        }
                    } else {
                        return StatusWorlde.SIMILARBLOCK;
                    }
                } else {
                    return StatusWorlde.SIMILARBLOCK;
                }
            } else {
                return StatusWorlde.SIMILARBLOCK;
            }
        } else {
            return StatusWorlde.WRONGBLOCK;
        }
    }
    
    public static StatusWorlde checkIndexShortWord(String enteredWordObject, int currentColumnObject) {
        int index1Object = enteredWordObject.substring(currentColumnObject + 1, enteredWordObject.length()).indexOf(
            Character.toString(enteredWordObject.charAt(currentColumnObject))) + (currentColumnObject + 1);
        if (enteredWordObject.substring(index1Object + 1, enteredWordObject.length()).contains(
                Character.toString(enteredWordObject.charAt(currentColumnObject)))) {
            int index2Object = enteredWordObject.substring(index1Object + 1, enteredWordObject.length()).indexOf(
                    Character.toString(enteredWordObject.charAt(currentColumnObject))) + index1Object + 1;
            if (enteredWordObject.substring(index2Object + 1, enteredWordObject.length()).contains(
                    Character.toString(enteredWordObject.charAt(currentColumnObject)))) {
                int index3Object = enteredWordObject.substring(index2Object + 1, enteredWordObject.length()).indexOf(
                        Character.toString(enteredWordObject.charAt(currentColumnObject))) + index2Object + 1;
                if (enteredWordObject.substring(index3Object + 1, enteredWordObject.length()).contains(
                        Character.toString(enteredWordObject.charAt(currentColumnObject)))) {
                    int index4Object = enteredWordObject.substring(index3Object + 1, enteredWordObject.length()).indexOf(
                            Character.toString(enteredWordObject.charAt(currentColumnObject))) + index3Object + 1;
                    if (currentWordObject.charAt(index1Object) == enteredWordObject.charAt(index1Object)) {
                        if (currentWordObject.charAt(index2Object) == enteredWordObject.charAt(index2Object)) {
                            return StatusWorlde.WRONGBLOCK;
                        } else if (currentWordObject.charAt(index3Object) == enteredWordObject.charAt(index3Object)) {
                            return StatusWorlde.WRONGBLOCK;
                        } else if (currentWordObject.charAt(index4Object) == enteredWordObject.charAt(index4Object)) {
                            return StatusWorlde.WRONGBLOCK;
                        } else {
                            return StatusWorlde.SIMILARBLOCK;
                        }
                    } else if (currentWordObject.charAt(index2Object) == enteredWordObject.charAt(index2Object)) {
                        if (currentWordObject.charAt(index3Object) == enteredWordObject.charAt(index3Object)) {
                            return StatusWorlde.WRONGBLOCK;
                        } else if (currentWordObject.charAt(index4Object) == enteredWordObject.charAt(index4Object)) {
                            return StatusWorlde.WRONGBLOCK;
                        } else {
                            return StatusWorlde.SIMILARBLOCK;
                        }
                    } else if (currentWordObject.charAt(index3Object) == enteredWordObject.charAt(index3Object)) {
                        if (currentWordObject.charAt(index4Object) == enteredWordObject.charAt(index4Object)) {
                            return StatusWorlde.WRONGBLOCK;
                        } else {
                            return StatusWorlde.SIMILARBLOCK;
                        }
                    } else {
                        return StatusWorlde.SIMILARBLOCK;
                    }
                } else {
                    if (currentWordObject.charAt(index1Object) == enteredWordObject.charAt(index1Object)) {
                        if (currentWordObject.charAt(index2Object) == enteredWordObject.charAt(index2Object)) {
                            return StatusWorlde.WRONGBLOCK;
                        } else if (currentWordObject.charAt(index3Object) == enteredWordObject.charAt(index3Object)) {
                            return StatusWorlde.WRONGBLOCK;
                        } else {
                            return StatusWorlde.SIMILARBLOCK;
                        }
                    } else if (currentWordObject.charAt(index2Object) == enteredWordObject.charAt(index2Object)) {
                        if (currentWordObject.charAt(index3Object) == enteredWordObject.charAt(index3Object)) {
                            return StatusWorlde.WRONGBLOCK;
                        } else {
                            return StatusWorlde.SIMILARBLOCK;
                        }
                    } else {
                        return StatusWorlde.SIMILARBLOCK;
                    }
                }
            } else {
                if (currentWordObject.charAt(index1Object) == enteredWordObject.charAt(index1Object)) {
                    if (currentWordObject.charAt(index2Object) == enteredWordObject.charAt(index2Object)) {
                        return StatusWorlde.WRONGBLOCK;
                    } else {
                        return StatusWorlde.SIMILARBLOCK;
                    }
                } else {
                    return StatusWorlde.SIMILARBLOCK;
                }
            }
        } else {
            return StatusWorlde.SIMILARBLOCK;
        }
    }
}