/*
 * Copyright 2013 Heiko Seeberger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package name.heikoseeberger.sos;

public class JavaTime implements Comparable<JavaTime> {

    private final int hours;

    private final int minutes;

    private final int asMinutes;

    public JavaTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        this.asMinutes = hours * 60 + minutes;
    }

    public JavaTime(int hours) {
        this(hours, 0);
    }

    public JavaTime() {
        this(0, 0);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int minus(JavaTime that) {
        return this.asMinutes - that.asMinutes;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JavaTime other = (JavaTime) obj;
        if (hours != other.hours)
            return false;
        if (minutes != other.minutes)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + hours;
        result = prime * result + minutes;
        return result;
    }

    @Override
    public int compareTo(JavaTime that) {
        return this.minus(that);
    }
}
