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

import org.nbyeti.jcclexer.JavaCharStream;
import org.nbyeti.jcclexer.Token;
import org.nbyeti.jcclexer.YetiParserTokenManager;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerInput;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author Christian
 */
class YetiLexer implements Lexer<YetiTokenId> {

    private LexerRestartInfo<YetiTokenId> info;
    private YetiParserTokenManager javaParserTokenManager;


    YetiLexer (LexerRestartInfo<YetiTokenId> info) {
        this.info = info;
        JavaCharStream stream = new JavaCharStream (info.input());
        javaParserTokenManager = new YetiParserTokenManager (stream);
    }

    public org.netbeans.api.lexer.Token<YetiTokenId> nextToken () {
        Token token = javaParserTokenManager.getNextToken ();
        if (info.input ().readLength () < 1) return null;
        return info.tokenFactory ().createToken (YetiLanguageHierarchy.getToken (token.kind));
    }

    public Object state () {
        return null;
    }

    public void release () {
    }
}