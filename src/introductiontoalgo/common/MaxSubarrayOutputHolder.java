package introductiontoalgo.common;

public class MaxSubarrayOutputHolder {
		private int startIndex;
		private int endIndex;
		private int maximumValue;
		
		
		public MaxSubarrayOutputHolder(int startIndex, int endIndex, int maximumValue) {
			super();
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.maximumValue = maximumValue;
		}
		public int getStartIndex() {
			return startIndex;
		}
		public void setStartIndex(int startIndex) {
			this.startIndex = startIndex;
		}
		public int getEndIndex() {
			return endIndex;
		}
		public void setEndIndex(int endIndex) {
			this.endIndex = endIndex;
		}
		public int getMaximumValue() {
			return maximumValue;
		}
		public void setMaximumValue(int maximumValue) {
			this.maximumValue = maximumValue;
		}
		
		@Override
		public String toString(){
			return "Start Index: " + getStartIndex() + " End Index: " + getEndIndex() + " Maximum Sum: " + getMaximumValue();
		}
}
