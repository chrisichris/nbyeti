/*
 * Copyright 2011 Christian Essl
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */

package org.nbyeti.lexer;

import static org.nbyeti.jcclexer.YetiParserConstants.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author Christian
 */
public class YetiLanguageHierarchy extends LanguageHierarchy<YetiTokenId> {

    private static List<YetiTokenId>  tokens;
    private static Map<Integer,YetiTokenId>
                                    idToToken;

    private static void init () {
        tokens = Arrays.<YetiTokenId> asList (new YetiTokenId[] {
            new YetiTokenId("EOF","whitespace",EOF),
            new YetiTokenId("WHITESPACE","whitespace",WHITESPACE),
            new YetiTokenId("SINGLE_LINE_COMMENT","comment",SINGLE_LINE_COMMENT),
            new YetiTokenId("TYPEDEF","keyword",TYPEDEF),
            new YetiTokenId("LOAD","keyword",LOAD),
            new YetiTokenId("PROGRAM","keyword",PROGRAM),
            new YetiTokenId("VAR","keyword",VAR),
            new YetiTokenId("LOOP","keyword",LOOP),
            new YetiTokenId("CASE","keyword",CASE),
            new YetiTokenId("ESAC","keyword",ESAC),
            new YetiTokenId("OF","keyword",OF),
            new YetiTokenId("TRY","keyword",TRY),
            new YetiTokenId("THROW","keyword",THROW),
            new YetiTokenId("CATCH","keyword",CATCH),
            new YetiTokenId("FINALLY","keyword",FINALLY),
            new YetiTokenId("YRT","keyword",YRT),
            new YetiTokenId("DO","keyword",DO),
            new YetiTokenId("DONE","keyword",DONE),
            new YetiTokenId("IF","keyword",IF),
            new YetiTokenId("FI","keyword",FI),
            new YetiTokenId("ELSE","keyword",ELSE),
            new YetiTokenId("ELIF","keyword",ELIF),
            new YetiTokenId("THEN","keyword",THEN),
            new YetiTokenId("IS","keyword",IS),
            new YetiTokenId("AS","keyword",AS),
            new YetiTokenId("UNSAFELY_AS","keyword",UNSAFELY_AS),
            new YetiTokenId("INSTANCEOF","keyword",INSTANCEOF),
            new YetiTokenId("NEW","keyword",NEW),
            new YetiTokenId("WITH","keyword",WITH),
            new YetiTokenId("SYNCHRONIZED","keyword",SYNCHRONIZED),
            new YetiTokenId("IMPORT","keyword",IMPORT),
            new YetiTokenId("MODULE","keyword",MODULE),
            new YetiTokenId("CLASS","keyword",CLASS),
            new YetiTokenId("ABSTRACT","keyword",ABSTRACT),
            new YetiTokenId("BOOLEAN","keyword",BOOLEAN),
            new YetiTokenId("BYTE","keyword",BYTE),
            new YetiTokenId("CHAR","keyword",CHAR),
            new YetiTokenId("DOUBLE","keyword",DOUBLE),
            new YetiTokenId("EXTENDS","keyword",EXTENDS),
            new YetiTokenId("FLOAT","keyword",FLOAT),
            new YetiTokenId("INT","keyword",INT),
            new YetiTokenId("LONG","keyword",LONG),
            new YetiTokenId("SHORT","keyword",SHORT),
            new YetiTokenId("THIS","keyword",THIS),
            new YetiTokenId("VOID","keyword",VOID),
            new YetiTokenId("END","keyword",END),
            new YetiTokenId("UNIT","literal",UNIT),
            new YetiTokenId("FALSE","literal",FALSE),
            new YetiTokenId("TRUE","literal",TRUE),
            new YetiTokenId("NUMBER_LITERAL","number",NUMBER_LITERAL),
            new YetiTokenId("INTEGER_LITERAL","number",INTEGER_LITERAL),
            new YetiTokenId("FLOATING_POINT_LITERAL","number",FLOATING_POINT_LITERAL),
            new YetiTokenId("DECIMAL_EXPONENT","number",DECIMAL_EXPONENT),
            new YetiTokenId("STRING_LITERAL","string",STRING_LITERAL),
            new YetiTokenId("IDENTIFIER","identifier",IDENTIFIER),
            new YetiTokenId("LETTER","identifier",LETTER),
            new YetiTokenId("PART_LETTER","identifier",PART_LETTER),
            new YetiTokenId("LPAREN","separator",LPAREN),
            new YetiTokenId("RPAREN","separator",RPAREN),
            new YetiTokenId("LBRACE","separator",LBRACE),
            new YetiTokenId("RBRACE","separator",RBRACE),
            new YetiTokenId("LBRACKET","separator",LBRACKET),
            new YetiTokenId("RBRACKET","separator",RBRACKET),
            new YetiTokenId("SEMICOLON","separator",SEMICOLON),
            new YetiTokenId("COMMA","separator",COMMA),
            new YetiTokenId("DOT","operator",DOT),
            new YetiTokenId("AT","operator",AT),
            new YetiTokenId("ASSIGN","assign",ASSIGN),
            new YetiTokenId("LT","operator",LT),
            new YetiTokenId("BANG","operator",BANG),
            new YetiTokenId("COLON","operator",COLON),
            new YetiTokenId("EQ","operator",EQ),
            new YetiTokenId("SC_OR","operator",SC_OR),
            new YetiTokenId("SC_AND","operator",SC_AND),
            new YetiTokenId("PLUS","operator",PLUS),
            new YetiTokenId("MINUS","operator",MINUS),
            new YetiTokenId("STAR","operator",STAR),
            new YetiTokenId("SLASH","operator",SLASH),
            new YetiTokenId("BIT_AND","operator",BIT_AND),
            new YetiTokenId("BIT_OR","operator",BIT_OR),
            new YetiTokenId("XOR","operator",XOR),
            new YetiTokenId("REM","operator",REM),
            new YetiTokenId("ELLIPSIS","operator",ELLIPSIS),
            new YetiTokenId("UNEXPECTED_CHAR","operator",UNEXPECTED_CHAR)
        });
        idToToken = new HashMap<Integer, YetiTokenId> ();
        for (YetiTokenId token : tokens)
            idToToken.put (token.ordinal (), token);
    }

    static synchronized YetiTokenId getToken (int id) {
        if (idToToken == null)
            init ();
        return idToToken.get (id);
    }

    protected synchronized Collection<YetiTokenId> createTokenIds () {
        if (tokens == null)
            init ();
        return tokens;
    }

    protected synchronized Lexer<YetiTokenId> createLexer (LexerRestartInfo<YetiTokenId> info) {
        return new YetiLexer (info);
    }

    protected String mimeType () {
        return "text/x-yeti";
    }
}
