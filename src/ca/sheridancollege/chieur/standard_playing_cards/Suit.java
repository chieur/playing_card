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

	final int UNICODE_OFFSET;
	final boolean IS_UNICODE_SHAPE_FILLING_UNINVERTED;

	Suit(int unicodeOffset, boolean isUnicodeShapeFillingUninverted) {
		this.UNICODE_OFFSET = unicodeOffset;
		this.IS_UNICODE_SHAPE_FILLING_UNINVERTED = isUnicodeShapeFillingUninverted;
	}

	char getCharacter(boolean isFilledShape) {
		int codepoint = 9824 + UNICODE_OFFSET;
		if (isFilledShape != IS_UNICODE_SHAPE_FILLING_UNINVERTED) {
			codepoint += 4;
		}
		return (char) codepoint;
	}
}