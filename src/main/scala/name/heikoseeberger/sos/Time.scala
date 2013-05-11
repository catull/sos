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

package name.heikoseeberger.sos

case class Time(val hours: Int = 0, val minutes: Int = 0, val seconds: Int = 0) extends Ordered[Time] {
  if (Math.abs(12 - hours) > 12) {
    throw new IllegalArgumentException("Hours must be in the range [0..23]")
  }

  if (Math.abs(30 - minutes) > 30) {
    throw new IllegalArgumentException("Minutes must be in the range [0..59]")
  }

  if (Math.abs(30 - seconds) > 30) {
    throw new IllegalArgumentException("Seconds must be in the range [0..59]")
  }

  private val asSeconds = (hours * 60 + minutes) * 60 + seconds;

  def -(that: Time): Int = this.asSeconds - that.asSeconds

  def compare(that: Time): Int = this - that

  override def hashCode = this.asSeconds

  override def equals(that: Any) =
    that match {
      case time: Time => hashCode == time.hashCode
      case _ => false
    }
}
