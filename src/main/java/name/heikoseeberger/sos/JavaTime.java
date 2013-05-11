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
  private final int seconds;
  private final int asSeconds;

  public JavaTime(final int hours, final int minutes, final int seconds) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
    this.asSeconds = ((hours * 60) + minutes) * 60 + seconds;
  }

  public JavaTime(final int hours, final int minutes) {
    this(hours, minutes, 0);
  }

  public JavaTime(final int hours) {
    this(hours, 0, 0);
  }

  public JavaTime() {
    this(0, 0, 0);
  }

  public int getHours() {
    return hours;
  }

  public int getMinutes() {
    return minutes;
  }

  public int getSeconds() {
    return seconds;
  }

  public int minus(final JavaTime that) {
    return this.asSeconds - that.asSeconds;
  }

  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof JavaTime)) {
      return false;
    }

    JavaTime other = (JavaTime) obj;

    return this.asSeconds == other.asSeconds;
  }

  @Override
  public int hashCode() {
    return asSeconds;
  }

  @Override
  public int compareTo(final JavaTime that) {
    return this.minus(that);
  }
}
