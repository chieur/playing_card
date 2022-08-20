/**
 *2022-07-27
 *
 * @author Ricky Chieu
 */
package ca.sheridancollege.chieur.standard_playing_cards;

public enum Suit {
	SPADE(0, true),
	HEART(1, false),
	CLUB(3, true),
	DIAMOND(2, false);

	final int unicodeOffset;
	final boolean isUnicodeShapeFillingUninverted;

	Suit(int unicodeOffset, boolean isUnicodeShapeFillingUninverted) {
		this.unicodeOffset = unicodeOffset;
		this.isUnicodeShapeFillingUninverted = isUnicodeShapeFillingUninverted;
	}

	char getCharacter(boolean isFilledShape) {
		int codepoint = 9824 + unicodeOffset;
		if (isFilledShape != isUnicodeShapeFillingUninverted) {
			codepoint += 4;
		}
		return (char) codepoint;
	}
}